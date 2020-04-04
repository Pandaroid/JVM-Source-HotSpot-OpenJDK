
JavaClasses::get_injected原始代码：
        ----------------------------------------
        InjectedField*JavaClasses::get_injected(Symbol*class_name,int*field_count){
        *field_count=0;

        vmSymbols::SID sid=vmSymbols::find_sid(class_name);
        if(sid==vmSymbols::NO_SID){
        // Only well known classes can inject fields
        return NULL;
        }

        int count=0;
        int start=-1;

        #define LOOKUP_INJECTED_FIELD(klass,name,signature,may_be_java) \
        if(sid==vmSymbols::VM_SYMBOL_ENUM_NAME(klass)){              \
        count++;                                                       \
        if(start==-1)start=klass##_##name##_enum;                \
        }
        ALL_INJECTED_FIELDS(LOOKUP_INJECTED_FIELD);
        #undef LOOKUP_INJECTED_FIELD

        if(start!=-1){
        *field_count=count;
        return _injected_fields+start;
        }
        return NULL;
        }
        ----------------------------------------


        LOOKUP_INJECTED_FIELD这个宏扩展后是
        ----------------------------------------
        //如果判断了第一个条件，对于相同的sid，后面的其实就不用再进行if (start == -1)判断了，
        //之所以这样，因为这段代码是用宏来实现的，只是为了编写宏时简单一些，反正代码的功能是正确的，只是看上去很笨拙。
        if(sid==vmSymbols::java_lang_Class_enum){count++;if(start==-1)start=java_lang_Class_klass_enum;}
        if(sid==vmSymbols::java_lang_Class_enum){count++;if(start==-1)start=java_lang_Class_array_klass_enum;}
        if(sid==vmSymbols::java_lang_Class_enum){count++;if(start==-1)start=java_lang_Class_oop_size_enum;}
        if(sid==vmSymbols::java_lang_Class_enum){count++;if(start==-1)start=java_lang_Class_static_oop_field_count_enum;}if(sid==vmSymbols::java_lang_Class_enum){count++;if(start==-1)start=java_lang_Class_protection_domain_enum;}
        if(sid==vmSymbols::java_lang_Class_enum){count++;if(start==-1)start=java_lang_Class_init_lock_enum;}
        if(sid==vmSymbols::java_lang_Class_enum){count++;if(start==-1)start=java_lang_Class_signers_enum;}

        if(sid==vmSymbols::java_lang_ClassLoader_enum){count++;if(start==-1)start=java_lang_ClassLoader_loader_data_enum;}

        if(sid==vmSymbols::java_lang_invoke_MemberName_enum){count++;if(start==-1)start=java_lang_invoke_MemberName_vmloader_enum;}
        if(sid==vmSymbols::java_lang_invoke_MemberName_enum){count++;if(start==-1)start=java_lang_invoke_MemberName_vmindex_enum;}
        if(sid==vmSymbols::java_lang_invoke_MemberName_enum){count++;if(start==-1)start=java_lang_invoke_MemberName_vmtarget_enum;};


        if(start!=-1){
        *field_count=count;
        //start是InjectedFieldID中的某个值，
        //InjectedFieldID与_injected_fields刚好是一一对应的
        return _injected_fields+start;
        }
        return 0;
        ----------------------------------------


        InjectedFieldID
        ----------------------------------------

enum InjectedFieldID {
    java_lang_Class_klass_enum,
    java_lang_Class_array_klass_enum,
    java_lang_Class_oop_size_enum,
    java_lang_Class_static_oop_field_count_enum,
    java_lang_Class_protection_domain_enum,
    java_lang_Class_init_lock_enum,
    java_lang_Class_signers_enum,

    java_lang_ClassLoader_loader_data_enum,

    java_lang_invoke_MemberName_vmloader_enum,
    java_lang_invoke_MemberName_vmindex_enum,
    java_lang_invoke_MemberName_vmtarget_enum,
    MAX_enum
};
----------------------------------------


        JavaClasses::_injected_fields
        ----------------------------------------
        InjectedField JavaClasses::_injected_fields[]={
        //分别对应InjectedField类的下面4个字段
        //systemDictionary::WKID klass_id         vmSymbols::SID name_index   vmSymbols::SID signature_index    bool may_be_java
        /////////////////////////////////         /////////////////////////   //////////////////////////////    ////////////////
        {SystemDictionary::java_lang_Class_knum,vmSymbols::klass_name_enum,vmSymbols::intptr_signature_enum,false},
        {SystemDictionary::java_lang_Class_knum,vmSymbols::array_klass_name_enum,vmSymbols::intptr_signature_enum,false},
        {SystemDictionary::java_lang_Class_knum,vmSymbols::oop_size_name_enum,vmSymbols::int_signature_enum,false},
        {SystemDictionary::java_lang_Class_knum,vmSymbols::static_oop_field_count_name_enum,vmSymbols::int_signature_enum,false},
        {SystemDictionary::java_lang_Class_knum,vmSymbols::protection_domain_name_enum,vmSymbols::object_signature_enum,false},
        {SystemDictionary::java_lang_Class_knum,vmSymbols::init_lock_name_enum,vmSymbols::object_signature_enum,false},
        {SystemDictionary::java_lang_Class_knum,vmSymbols::signers_name_enum,vmSymbols::object_signature_enum,false},

        {SystemDictionary::java_lang_ClassLoader_knum,vmSymbols::loader_data_name_enum,vmSymbols::intptr_signature_enum,false},

        {SystemDictionary::java_lang_invoke_MemberName_knum,vmSymbols::vmloader_name_enum,vmSymbols::object_signature_enum,false},
        {SystemDictionary::java_lang_invoke_MemberName_knum,vmSymbols::vmindex_name_enum,vmSymbols::intptr_signature_enum,false},
        {SystemDictionary::java_lang_invoke_MemberName_knum,vmSymbols::vmtarget_name_enum,vmSymbols::intptr_signature_enum,false},
        };
        ----------------------------------------


enum {
        log2_SID_LIMIT=10
        };


enum WKID { //WKID 是well known id的缩写
    NO_WKID =0,

    //////////////////////////////////////////////
    Object_klass_knum,
    java_lang_Object_knum =Object_klass_knum,

    String_klass_knum,
    java_lang_String_knum =String_klass_knum,

    Class_klass_knum,
    java_lang_Class_knum =Class_klass_knum,

    Cloneable_klass_knum,
    java_lang_Cloneable_knum =Cloneable_klass_knum,

    ClassLoader_klass_knum,
    java_lang_ClassLoader_knum =ClassLoader_klass_knum,

    Serializable_klass_knum,
    java_io_Serializable_knum =Serializable_klass_knum,

    System_klass_knum,
    java_lang_System_knum =System_klass_knum,

    Throwable_klass_knum,
    java_lang_Throwable_knum =Throwable_klass_knum,

    Error_klass_knum,
    java_lang_Error_knum =Error_klass_knum,

    ThreadDeath_klass_knum,
    java_lang_ThreadDeath_knum =ThreadDeath_klass_knum,

    Exception_klass_knum,
    java_lang_Exception_knum =Exception_klass_knum,

    RuntimeException_klass_knum,
    java_lang_RuntimeException_knum =RuntimeException_klass_knum,

    SecurityManager_klass_knum,
    java_lang_SecurityManager_knum =SecurityManager_klass_knum,

    ProtectionDomain_klass_knum,
    java_security_ProtectionDomain_knum =ProtectionDomain_klass_knum,

    AccessControlContext_klass_knum,
    java_security_AccessControlContext_knum =AccessControlContext_klass_knum,

    ClassNotFoundException_klass_knum,
    java_lang_ClassNotFoundException_knum =ClassNotFoundException_klass_knum,

    NoClassDefFoundError_klass_knum,
    java_lang_NoClassDefFoundError_knum =NoClassDefFoundError_klass_knum,

    LinkageError_klass_knum,
    java_lang_LinkageError_knum =LinkageError_klass_knum,

    ClassCastException_klass_knum,
    java_lang_ClassCastException_knum =ClassCastException_klass_knum,

    ArrayStoreException_klass_knum,
    java_lang_ArrayStoreException_knum =ArrayStoreException_klass_knum,

    VirtualMachineError_klass_knum,
    java_lang_VirtualMachineError_knum =VirtualMachineError_klass_knum,

    OutOfMemoryError_klass_knum,
    java_lang_OutOfMemoryError_knum =OutOfMemoryError_klass_knum,

    StackOverflowError_klass_knum,
    java_lang_StackOverflowError_knum =StackOverflowError_klass_knum,

    IllegalMonitorStateException_klass_knum,
    java_lang_IllegalMonitorStateException_knum =IllegalMonitorStateException_klass_knum,

    Reference_klass_knum,
    java_lang_ref_Reference_knum =Reference_klass_knum,


    /*Preloadrefklassesandsetreferencetypes*/
    SoftReference_klass_knum,
    java_lang_ref_SoftReference_knum =SoftReference_klass_knum,

    WeakReference_klass_knum,
    java_lang_ref_WeakReference_knum =WeakReference_klass_knum,

    FinalReference_klass_knum,
    java_lang_ref_FinalReference_knum =FinalReference_klass_knum,

    PhantomReference_klass_knum,
    java_lang_ref_PhantomReference_knum =PhantomReference_klass_knum,

    Finalizer_klass_knum,
    java_lang_ref_Finalizer_knum =Finalizer_klass_knum,


    Thread_klass_knum,
    java_lang_Thread_knum =Thread_klass_knum,

    ThreadGroup_klass_knum,
    java_lang_ThreadGroup_knum =ThreadGroup_klass_knum,

    Properties_klass_knum,
    java_util_Properties_knum =Properties_klass_knum,

    reflect_AccessibleObject_klass_knum,
    java_lang_reflect_AccessibleObject_knum =reflect_AccessibleObject_klass_knum,

    reflect_Field_klass_knum,
    java_lang_reflect_Field_knum =reflect_Field_klass_knum,

    reflect_Parameter_klass_knum,
    java_lang_reflect_Parameter_knum =reflect_Parameter_klass_knum,

    reflect_Method_klass_knum,
    java_lang_reflect_Method_knum =reflect_Method_klass_knum,

    reflect_Constructor_klass_knum,
    java_lang_reflect_Constructor_knum =reflect_Constructor_klass_knum,


    /*NOTE:neededtooearlyinbootstrappingprocesstohavechecksbasedonJDKversion*/
    /*Universe::is_gte_jdk14x_version()isnotsetupbythispoint.*/
    /*It'sokayifthisturnsouttobeNULLinnon-1.4JDKs.*/
    reflect_MagicAccessorImpl_klass_knum,
    sun_reflect_MagicAccessorImpl_knum =reflect_MagicAccessorImpl_klass_knum,

    reflect_MethodAccessorImpl_klass_knum,
    sun_reflect_MethodAccessorImpl_knum =reflect_MethodAccessorImpl_klass_knum,

    reflect_ConstructorAccessorImpl_klass_knum,
    sun_reflect_ConstructorAccessorImpl_knum =reflect_ConstructorAccessorImpl_klass_knum,

    reflect_DelegatingClassLoader_klass_knum,
    sun_reflect_DelegatingClassLoader_knum =reflect_DelegatingClassLoader_klass_knum,

    reflect_ConstantPool_klass_knum,
    sun_reflect_ConstantPool_knum =reflect_ConstantPool_klass_knum,

    reflect_UnsafeStaticFieldAccessorImpl_klass_knum,
    sun_reflect_UnsafeStaticFieldAccessorImpl_knum =reflect_UnsafeStaticFieldAccessorImpl_klass_knum,

    reflect_CallerSensitive_klass_knum,
    sun_reflect_CallerSensitive_knum =reflect_CallerSensitive_klass_knum,


    /*supportfordynamictyping;it'sOKiftheseareNULLinearlierJDKs*/
    DirectMethodHandle_klass_knum,
    java_lang_invoke_DirectMethodHandle_knum =DirectMethodHandle_klass_knum,

    MethodHandle_klass_knum,
    java_lang_invoke_MethodHandle_knum =MethodHandle_klass_knum,

    MemberName_klass_knum,
    java_lang_invoke_MemberName_knum =MemberName_klass_knum,

    MethodHandleNatives_klass_knum,
    java_lang_invoke_MethodHandleNatives_knum =MethodHandleNatives_klass_knum,

    LambdaForm_klass_knum,
    java_lang_invoke_LambdaForm_knum =LambdaForm_klass_knum,

    MethodType_klass_knum,
    java_lang_invoke_MethodType_knum =MethodType_klass_knum,

    BootstrapMethodError_klass_knum,
    java_lang_BootstrapMethodError_knum =BootstrapMethodError_klass_knum,

    CallSite_klass_knum,
    java_lang_invoke_CallSite_knum =CallSite_klass_knum,

    ConstantCallSite_klass_knum,
    java_lang_invoke_ConstantCallSite_knum =ConstantCallSite_klass_knum,

    MutableCallSite_klass_knum,
    java_lang_invoke_MutableCallSite_knum =MutableCallSite_klass_knum,

    VolatileCallSite_klass_knum,
    java_lang_invoke_VolatileCallSite_knum =VolatileCallSite_klass_knum,

		/*Note:MethodHandlemustbefirst,
		andVolatileCallSitelastingroup*/

    StringBuffer_klass_knum,
    java_lang_StringBuffer_knum =StringBuffer_klass_knum,

    StringBuilder_klass_knum,
    java_lang_StringBuilder_knum =StringBuilder_klass_knum,

    misc_Unsafe_klass_knum,
    sun_misc_Unsafe_knum =misc_Unsafe_klass_knum,


    /*It'sNULLinnon-1.4JDKs.*/
    StackTraceElement_klass_knum,
    java_lang_StackTraceElement_knum =StackTraceElement_klass_knum,

    /*Universe::is_gte_jdk14x_version()isnotsetupbythispoint.*/
    /*It'sokayifthisturnsouttobeNULLinnon-1.4JDKs.*/
    nio_Buffer_klass_knum,
    java_nio_Buffer_knum =nio_Buffer_klass_knum,


    /*Preloadboxingklasses*/
    Boolean_klass_knum,
    java_lang_Boolean_knum =Boolean_klass_knum,

    Character_klass_knum,
    java_lang_Character_knum =Character_klass_knum,

    Float_klass_knum,
    java_lang_Float_knum =Float_klass_knum,

    Double_klass_knum,
    java_lang_Double_knum =Double_klass_knum,

    Byte_klass_knum,
    java_lang_Byte_knum =Byte_klass_knum,

    Short_klass_knum,
    java_lang_Short_knum =Short_klass_knum,

    Integer_klass_knum,
    java_lang_Integer_knum =Integer_klass_knum,

    Long_klass_knum,
    java_lang_Long_knum =Long_klass_knum,

    WKID_LIMIT,

    FIRST_WKID =NO_WKID +1
};


enum SID {
    NO_SID =0,

    //////////////////////////////
    java_lang_System_enum,
    java_lang_Object_enum,
    java_lang_Class_enum,
    java_lang_String_enum,
    java_lang_Thread_enum,
    java_lang_ThreadGroup_enum,
    java_lang_Cloneable_enum,
    java_lang_Throwable_enum,
    java_lang_ClassLoader_enum,
    java_lang_ClassLoader_NativeLibrary_enum,
    java_lang_ThreadDeath_enum,
    java_lang_Boolean_enum,
    java_lang_Character_enum,
    java_lang_Character_CharacterCache_enum,
    java_lang_Float_enum,
    java_lang_Double_enum,
    java_lang_Byte_enum,
    java_lang_Byte_ByteCache_enum,
    java_lang_Short_enum,
    java_lang_Short_ShortCache_enum,
    java_lang_Integer_enum,
    java_lang_Integer_IntegerCache_enum,
    java_lang_Long_enum,
    java_lang_Long_LongCache_enum,
    java_lang_Shutdown_enum,
    java_lang_ref_Reference_enum,
    java_lang_ref_SoftReference_enum,
    java_lang_ref_WeakReference_enum,
    java_lang_ref_FinalReference_enum,
    java_lang_ref_PhantomReference_enum,
    java_lang_ref_Finalizer_enum,
    java_lang_reflect_AccessibleObject_enum,
    java_lang_reflect_Method_enum,
    java_lang_reflect_Constructor_enum,
    java_lang_reflect_Field_enum,
    java_lang_reflect_Parameter_enum,
    java_lang_reflect_Array_enum,
    java_lang_StringBuffer_enum,
    java_lang_StringBuilder_enum,
    java_lang_CharSequence_enum,
    java_lang_SecurityManager_enum,
    java_security_AccessControlContext_enum,
    java_security_ProtectionDomain_enum,
    impliesCreateAccessControlContext_name_enum,
    java_io_OutputStream_enum,
    java_io_Reader_enum,
    java_io_BufferedReader_enum,
    java_io_FileInputStream_enum,
    java_io_ByteArrayInputStream_enum,
    java_io_Serializable_enum,
    java_util_Arrays_enum,
    java_util_Properties_enum,
    java_util_Vector_enum,
    java_util_AbstractList_enum,
    java_util_Hashtable_enum,
    java_lang_Compiler_enum,
    sun_misc_Signal_enum,
    java_lang_AssertionStatusDirectives_enum,
    getBootClassPathEntryForClass_name_enum,
    sun_misc_PostVMInitHook_enum,
    sun_misc_Launcher_ExtClassLoader_enum,
    sun_misc_Version_enum,
    java_runtime_name_name_enum,
    java_runtime_version_name_enum,
    tag_source_file_enum,
    tag_inner_classes_enum,
    tag_constant_value_enum,
    tag_code_enum,
    tag_exceptions_enum,
    tag_line_number_table_enum,
    tag_local_variable_table_enum,
    tag_local_variable_type_table_enum,
    tag_method_parameters_enum,
    tag_stack_map_table_enum,
    tag_synthetic_enum,
    tag_deprecated_enum,
    tag_source_debug_extension_enum,
    tag_signature_enum,
    tag_runtime_visible_annotations_enum,
    tag_runtime_invisible_annotations_enum,
    tag_runtime_visible_parameter_annotations_enum,
    tag_runtime_invisible_parameter_annotations_enum,
    tag_annotation_default_enum,
    tag_runtime_visible_type_annotations_enum,
    tag_runtime_invisible_type_annotations_enum,
    tag_enclosing_method_enum,
    tag_bootstrap_methods_enum,
    java_lang_ArithmeticException_enum,
    java_lang_ArrayIndexOutOfBoundsException_enum,
    java_lang_ArrayStoreException_enum,
    java_lang_ClassCastException_enum,
    java_lang_ClassNotFoundException_enum,
    java_lang_CloneNotSupportedException_enum,
    java_lang_IllegalAccessException_enum,
    java_lang_IllegalArgumentException_enum,
    java_lang_IllegalStateException_enum,
    java_lang_IllegalMonitorStateException_enum,
    java_lang_IllegalThreadStateException_enum,
    java_lang_IndexOutOfBoundsException_enum,
    java_lang_InstantiationException_enum,
    java_lang_InstantiationError_enum,
    java_lang_InterruptedException_enum,
    java_lang_BootstrapMethodError_enum,
    java_lang_LinkageError_enum,
    java_lang_NegativeArraySizeException_enum,
    java_lang_NoSuchFieldException_enum,
    java_lang_NoSuchMethodException_enum,
    java_lang_NullPointerException_enum,
    java_lang_StringIndexOutOfBoundsException_enum,
    java_lang_UnsupportedOperationException_enum,
    java_lang_InvalidClassException_enum,
    java_lang_reflect_InvocationTargetException_enum,
    java_lang_Exception_enum,
    java_lang_RuntimeException_enum,
    java_io_IOException_enum,
    java_security_PrivilegedActionException_enum,
    java_lang_AbstractMethodError_enum,
    java_lang_ClassCircularityError_enum,
    java_lang_ClassFormatError_enum,
    java_lang_UnsupportedClassVersionError_enum,
    java_lang_Error_enum,
    java_lang_ExceptionInInitializerError_enum,
    java_lang_IllegalAccessError_enum,
    java_lang_IncompatibleClassChangeError_enum,
    java_lang_InternalError_enum,
    java_lang_NoClassDefFoundError_enum,
    java_lang_NoSuchFieldError_enum,
    java_lang_NoSuchMethodError_enum,
    java_lang_OutOfMemoryError_enum,
    java_lang_UnsatisfiedLinkError_enum,
    java_lang_VerifyError_enum,
    java_lang_SecurityException_enum,
    java_lang_VirtualMachineError_enum,
    java_lang_StackOverflowError_enum,
    java_lang_StackTraceElement_enum,
    java_util_concurrent_locks_AbstractOwnableSynchronizer_enum,
    sun_misc_Contended_signature_enum,
    java_lang_Math_enum,
    java_lang_StrictMath_enum,
    java_nio_Buffer_enum,
    sun_nio_cs_iso8859_1_Encoder_enum,
    com_sun_crypto_provider_aescrypt_enum,
    com_sun_crypto_provider_cipherBlockChaining_enum,
    java_util_zip_CRC32_enum,
    sun_misc_Unsafe_enum,
    sun_reflect_FieldInfo_enum,
    sun_reflect_MethodInfo_enum,
    sun_reflect_MagicAccessorImpl_enum,
    sun_reflect_MethodAccessorImpl_enum,
    sun_reflect_ConstructorAccessorImpl_enum,
    sun_reflect_SerializationConstructorAccessorImpl_enum,
    sun_reflect_DelegatingClassLoader_enum,
    sun_reflect_Reflection_enum,
    sun_reflect_CallerSensitive_enum,
    sun_reflect_CallerSensitive_signature_enum,
    checkedExceptions_name_enum,
    clazz_name_enum,
    exceptionTypes_name_enum,
    modifiers_name_enum,
    newConstructor_name_enum,
    newConstructor_signature_enum,
    newField_name_enum,
    newField_signature_enum,
    newMethod_name_enum,
    newMethod_signature_enum,
    invokeBasic_name_enum,
    linkToVirtual_name_enum,
    linkToStatic_name_enum,
    linkToSpecial_name_enum,
    linkToInterface_name_enum,
    compiledLambdaForm_name_enum,
    star_name_enum,
    invoke_name_enum,
    override_name_enum,
    parameterTypes_name_enum,
    returnType_name_enum,
    signature_name_enum,
    slot_name_enum,
    selectAlternative_name_enum,
    annotations_name_enum,
    index_name_enum,
    executable_name_enum,
    parameter_annotations_name_enum,
    annotation_default_name_enum,
    sun_reflect_ConstantPool_enum,
    ConstantPool_name_enum,
    sun_reflect_UnsafeStaticFieldAccessorImpl_enum,
    base_name_enum,
    type_annotations_name_enum,
    java_lang_invoke_CallSite_enum,
    java_lang_invoke_ConstantCallSite_enum,
    java_lang_invoke_DirectMethodHandle_enum,
    java_lang_invoke_MutableCallSite_enum,
    java_lang_invoke_VolatileCallSite_enum,
    java_lang_invoke_MethodHandle_enum,
    java_lang_invoke_MethodType_enum,
    java_lang_invoke_MethodType_signature_enum,
    java_lang_invoke_MemberName_signature_enum,
    java_lang_invoke_LambdaForm_signature_enum,
    java_lang_invoke_MethodHandle_signature_enum,
    java_lang_invoke_MemberName_enum,
    java_lang_invoke_MethodHandleNatives_enum,
    java_lang_invoke_LambdaForm_enum,
    java_lang_invoke_ForceInline_signature_enum,
    java_lang_invoke_DontInline_signature_enum,
    java_lang_invoke_Stable_signature_enum,
    java_lang_invoke_LambdaForm_Compiled_signature_enum,
    java_lang_invoke_LambdaForm_Hidden_signature_enum,
    findMethodHandleType_name_enum,
    findMethodHandleType_signature_enum,
    linkMethodHandleConstant_name_enum,
    linkMethodHandleConstant_signature_enum,
    linkMethod_name_enum,
    linkMethod_signature_enum,
    linkCallSite_name_enum,
    linkCallSite_signature_enum,
    setTargetNormal_name_enum,
    setTargetVolatile_name_enum,
    setTarget_signature_enum,
    selectAlternative_signature_enum,
    object_initializer_name_enum,
    class_initializer_name_enum,
    println_name_enum,
    printStackTrace_name_enum,
    main_name_enum,
    name_name_enum,
    priority_name_enum,
    stillborn_name_enum,
    group_name_enum,
    daemon_name_enum,
    eetop_name_enum,
    thread_status_name_enum,
    run_method_name_enum,
    exit_method_name_enum,
    add_method_name_enum,
    remove_method_name_enum,
    parent_name_enum,
    threads_name_enum,
    groups_name_enum,
    maxPriority_name_enum,
    destroyed_name_enum,
    vmAllowSuspension_name_enum,
    nthreads_name_enum,
    ngroups_name_enum,
    shutdown_method_name_enum,
    finalize_method_name_enum,
    reference_lock_name_enum,
    reference_discovered_name_enum,
    run_finalization_name_enum,
    run_finalizers_on_exit_name_enum,
    uncaughtException_name_enum,
    dispatchUncaughtException_name_enum,
    initializeSystemClass_name_enum,
    loadClass_name_enum,
    loadClassInternal_name_enum,
    get_name_enum,
    put_name_enum,
    type_name_enum,
    findNative_name_enum,
    deadChild_name_enum,
    addClass_name_enum,
    throwIllegalAccessError_name_enum,
    getFromClass_name_enum,
    dispatch_name_enum,
    getSystemClassLoader_name_enum,
    fillInStackTrace_name_enum,
    fillInStackTrace0_name_enum,
    getCause_name_enum,
    initCause_name_enum,
    setProperty_name_enum,
    getProperty_name_enum,
    context_name_enum,
    privilegedContext_name_enum,
    contextClassLoader_name_enum,
    inheritedAccessControlContext_name_enum,
    isPrivileged_name_enum,
    isAuthorized_name_enum,
    getClassContext_name_enum,
    wait_name_enum,
    checkPackageAccess_name_enum,
    stackSize_name_enum,
    thread_id_name_enum,
    newInstance0_name_enum,
    limit_name_enum,
    member_name_enum,
    forName_name_enum,
    forName0_name_enum,
    isJavaIdentifierStart_name_enum,
    isJavaIdentifierPart_name_enum,
    exclusive_owner_thread_name_enum,
    park_blocker_name_enum,
    park_event_name_enum,
    cache_field_name_enum,
    value_name_enum,
    offset_name_enum,
    count_name_enum,
    hash_name_enum,
    numberOfLeadingZeros_name_enum,
    numberOfTrailingZeros_name_enum,
    bitCount_name_enum,
    profile_name_enum,
    equals_name_enum,
    target_name_enum,
    toString_name_enum,
    values_name_enum,
    receiver_name_enum,
    vmtarget_name_enum,
    next_target_name_enum,
    vmloader_name_enum,
    vmindex_name_enum,
    vmcount_name_enum,
    vmentry_name_enum,
    flags_name_enum,
    rtype_name_enum,
    ptypes_name_enum,
    form_name_enum,
    basicType_name_enum,
    append_name_enum,
    klass_name_enum,
    array_klass_name_enum,
    oop_size_name_enum,
    static_oop_field_count_name_enum,
    protection_domain_name_enum,
    init_lock_name_enum,
    signers_name_enum,
    loader_data_name_enum,
    dependencies_name_enum,
    register_method_name_enum,
    hashCode_name_enum,
    getClass_name_enum,
    clone_name_enum,
    abs_name_enum,
    sin_name_enum,
    cos_name_enum,
    tan_name_enum,
    atan2_name_enum,
    sqrt_name_enum,
    log_name_enum,
    log10_name_enum,
    pow_name_enum,
    exp_name_enum,
    min_name_enum,
    max_name_enum,
    addExact_name_enum,
    decrementExact_name_enum,
    incrementExact_name_enum,
    multiplyExact_name_enum,
    negateExact_name_enum,
    subtractExact_name_enum,
    floatToRawIntBits_name_enum,
    floatToIntBits_name_enum,
    intBitsToFloat_name_enum,
    doubleToRawLongBits_name_enum,
    doubleToLongBits_name_enum,
    longBitsToDouble_name_enum,
    reverseBytes_name_enum,
    identityHashCode_name_enum,
    currentTimeMillis_name_enum,
    nanoTime_name_enum,
    arraycopy_name_enum,
    isInterrupted_name_enum,
    currentThread_name_enum,
    isAssignableFrom_name_enum,
    isInstance_name_enum,
    getModifiers_name_enum,
    isInterface_name_enum,
    isArray_name_enum,
    isPrimitive_name_enum,
    getSuperclass_name_enum,
    getComponentType_name_enum,
    getClassAccessFlags_name_enum,
    getLength_name_enum,
    getCallerClass_name_enum,
    newArray_name_enum,
    copyOf_name_enum,
    copyOfRange_name_enum,
    compareTo_name_enum,
    indexOf_name_enum,
    checkIndex_name_enum,
    encodeISOArray_name_enum,
    encryptBlock_name_enum,
    decryptBlock_name_enum,
    encrypt_name_enum,
    decrypt_name_enum,
    update_name_enum,
    updateBytes_name_enum,
    updateByteBuffer_name_enum,
    allocateInstance_name_enum,
    copyMemory_name_enum,
    park_name_enum,
    unpark_name_enum,
    loadFence_name_enum,
    storeFence_name_enum,
    fullFence_name_enum,
    getObject_name_enum,
    putObject_name_enum,
    getBoolean_name_enum,
    putBoolean_name_enum,
    getByte_name_enum,
    putByte_name_enum,
    getShort_name_enum,
    putShort_name_enum,
    getChar_name_enum,
    putChar_name_enum,
    getInt_name_enum,
    putInt_name_enum,
    getLong_name_enum,
    putLong_name_enum,
    getFloat_name_enum,
    putFloat_name_enum,
    getDouble_name_enum,
    putDouble_name_enum,
    getObjectVolatile_name_enum,
    putObjectVolatile_name_enum,
    getBooleanVolatile_name_enum,
    putBooleanVolatile_name_enum,
    getByteVolatile_name_enum,
    putByteVolatile_name_enum,
    getShortVolatile_name_enum,
    putShortVolatile_name_enum,
    getCharVolatile_name_enum,
    putCharVolatile_name_enum,
    getIntVolatile_name_enum,
    putIntVolatile_name_enum,
    getLongVolatile_name_enum,
    putLongVolatile_name_enum,
    getFloatVolatile_name_enum,
    putFloatVolatile_name_enum,
    getDoubleVolatile_name_enum,
    putDoubleVolatile_name_enum,
    getAddress_name_enum,
    putAddress_name_enum,
    compareAndSwapObject_name_enum,
    compareAndSwapLong_name_enum,
    compareAndSwapInt_name_enum,
    putOrderedObject_name_enum,
    putOrderedLong_name_enum,
    putOrderedInt_name_enum,
    getAndAddInt_name_enum,
    getAndAddLong_name_enum,
    getAndSetInt_name_enum,
    getAndSetLong_name_enum,
    getAndSetObject_name_enum,
    prefetchRead_name_enum,
    prefetchWrite_name_enum,
    prefetchReadStatic_name_enum,
    prefetchWriteStatic_name_enum,
    booleanValue_name_enum,
    byteValue_name_enum,
    charValue_name_enum,
    shortValue_name_enum,
    intValue_name_enum,
    longValue_name_enum,
    floatValue_name_enum,
    doubleValue_name_enum,
    valueOf_name_enum,
    Boolean_valueOf_signature_enum,
    Byte_valueOf_signature_enum,
    Character_valueOf_signature_enum,
    Short_valueOf_signature_enum,
    Integer_valueOf_signature_enum,
    Long_valueOf_signature_enum,
    Float_valueOf_signature_enum,
    Double_valueOf_signature_enum,
    void_method_signature_enum,
    void_boolean_signature_enum,
    void_byte_signature_enum,
    void_char_signature_enum,
    void_short_signature_enum,
    void_int_signature_enum,
    void_long_signature_enum,
    void_float_signature_enum,
    void_double_signature_enum,
    int_void_signature_enum,
    int_int_signature_enum,
    char_char_signature_enum,
    short_short_signature_enum,
    int_bool_signature_enum,
    float_int_signature_enum,
    double_long_signature_enum,
    double_double_signature_enum,
    int_float_signature_enum,
    long_int_signature_enum,
    long_long_signature_enum,
    long_double_signature_enum,
    byte_signature_enum,
    char_signature_enum,
    double_signature_enum,
    float_signature_enum,
    int_signature_enum,
    long_signature_enum,
    short_signature_enum,
    bool_signature_enum,
    void_signature_enum,
    byte_array_signature_enum,
    char_array_signature_enum,
    int_array_signature_enum,
    object_void_signature_enum,
    object_int_signature_enum,
    object_boolean_signature_enum,
    string_void_signature_enum,
    string_int_signature_enum,
    throwable_void_signature_enum,
    void_throwable_signature_enum,
    throwable_throwable_signature_enum,
    class_void_signature_enum,
    class_int_signature_enum,
    class_long_signature_enum,
    class_boolean_signature_enum,
    throwable_string_void_signature_enum,
    string_array_void_signature_enum,
    string_array_string_array_void_signature_enum,
    thread_throwable_void_signature_enum,
    thread_void_signature_enum,
    threadgroup_runnable_void_signature_enum,
    threadgroup_string_void_signature_enum,
    string_class_signature_enum,
    object_object_object_signature_enum,
    string_string_string_signature_enum,
    string_string_signature_enum,
    classloader_string_long_signature_enum,
    byte_array_void_signature_enum,
    char_array_void_signature_enum,
    int_int_void_signature_enum,
    long_long_void_signature_enum,
    void_classloader_signature_enum,
    void_object_signature_enum,
    void_class_signature_enum,
    void_class_array_signature_enum,
    void_string_signature_enum,
    object_array_object_signature_enum,
    object_object_array_object_signature_enum,
    exception_void_signature_enum,
    protectiondomain_signature_enum,
    accesscontrolcontext_signature_enum,
    class_protectiondomain_signature_enum,
    thread_signature_enum,
    thread_array_signature_enum,
    threadgroup_signature_enum,
    threadgroup_array_signature_enum,
    class_array_signature_enum,
    classloader_signature_enum,
    object_signature_enum,
    class_signature_enum,
    string_signature_enum,
    reference_signature_enum,
    executable_signature_enum,
    concurrenthashmap_signature_enum,
    String_StringBuilder_signature_enum,
    int_StringBuilder_signature_enum,
    char_StringBuilder_signature_enum,
    String_StringBuffer_signature_enum,
    int_StringBuffer_signature_enum,
    char_StringBuffer_signature_enum,
    int_String_signature_enum,
    double2_double_signature_enum,
    int2_int_signature_enum,
    long2_long_signature_enum,
    arraycopy_signature_enum,
    isInterrupted_signature_enum,
    currentThread_signature_enum,
    newArray_signature_enum,
    copyOf_signature_enum,
    copyOfRange_signature_enum,
    equalsC_signature_enum,
    encodeISOArray_signature_enum,
    byteArray_int_byteArray_int_signature_enum,
    byteArray_int_int_byteArray_int_signature_enum,
    updateBytes_signature_enum,
    updateByteBuffer_signature_enum,
    allocateInstance_signature_enum,
    copyMemory_signature_enum,
    park_signature_enum,
    getObject_signature_enum,
    putObject_signature_enum,
    getBoolean_signature_enum,
    putBoolean_signature_enum,
    getByte_signature_enum,
    putByte_signature_enum,
    getShort_signature_enum,
    putShort_signature_enum,
    getChar_signature_enum,
    putChar_signature_enum,
    getInt_signature_enum,
    putInt_signature_enum,
    getLong_signature_enum,
    putLong_signature_enum,
    getFloat_signature_enum,
    putFloat_signature_enum,
    getDouble_signature_enum,
    putDouble_signature_enum,
    getByte_raw_signature_enum,
    putByte_raw_signature_enum,
    getShort_raw_signature_enum,
    putShort_raw_signature_enum,
    getChar_raw_signature_enum,
    putChar_raw_signature_enum,
    putInt_raw_signature_enum,
    getFloat_raw_signature_enum,
    putFloat_raw_signature_enum,
    putDouble_raw_signature_enum,
    compareAndSwapObject_signature_enum,
    compareAndSwapLong_signature_enum,
    compareAndSwapInt_signature_enum,
    getAndAddInt_signature_enum,
    getAndAddLong_signature_enum,
    getAndSetObject_signature_enum,
    prefetch_signature_enum,
    dummy_symbol_enum,
    unknown_class_name_enum,
    parallelCapable_name_enum,
    java_lang_StackTraceElement_array_enum,
    java_lang_management_ThreadState_enum,
    java_lang_management_MemoryUsage_enum,
    java_lang_management_ThreadInfo_enum,
    sun_management_ManagementFactory_enum,
    sun_management_Sensor_enum,
    sun_management_Agent_enum,
    sun_management_DiagnosticCommandImpl_enum,
    sun_management_GarbageCollectorImpl_enum,
    sun_management_ManagementFactoryHelper_enum,
    getDiagnosticCommandMBean_name_enum,
    getDiagnosticCommandMBean_signature_enum,
    getGcInfoBuilder_name_enum,
    getGcInfoBuilder_signature_enum,
    com_sun_management_GcInfo_enum,
    com_sun_management_GcInfo_constructor_signature_enum,
    createGCNotification_name_enum,
    createGCNotification_signature_enum,
    createDiagnosticFrameworkNotification_name_enum,
    createMemoryPoolMBean_name_enum,
    createMemoryManagerMBean_name_enum,
    createGarbageCollectorMBean_name_enum,
    createMemoryPoolMBean_signature_enum,
    createMemoryManagerMBean_signature_enum,
    createGarbageCollectorMBean_signature_enum,
    trigger_name_enum,
    clear_name_enum,
    trigger_method_signature_enum,
    startAgent_name_enum,
    startRemoteAgent_name_enum,
    startLocalAgent_name_enum,
    stopRemoteAgent_name_enum,
    java_lang_management_ThreadInfo_constructor_signature_enum,
    java_lang_management_ThreadInfo_with_locks_constructor_signature_enum,
    long_long_long_long_void_signature_enum,
    java_lang_management_MemoryPoolMXBean_enum,
    java_lang_management_MemoryManagerMXBean_enum,
    java_lang_management_GarbageCollectorMXBean_enum,
    gcInfoBuilder_name_enum,
    createMemoryPool_name_enum,
    createMemoryManager_name_enum,
    createGarbageCollector_name_enum,
    createMemoryPool_signature_enum,
    createMemoryManager_signature_enum,
    createGarbageCollector_signature_enum,
    addThreadDumpForMonitors_name_enum,
    addThreadDumpForSynchronizers_name_enum,
    addThreadDumpForMonitors_signature_enum,
    addThreadDumpForSynchronizers_signature_enum,
    sun_misc_VMSupport_enum,
    appendToClassPathForInstrumentation_name_enum,
    serializePropertiesToByteArray_name_enum,
    serializePropertiesToByteArray_signature_enum,
    serializeAgentPropertiesToByteArray_name_enum,
    classRedefinedCount_name_enum,


    SID_LIMIT,


    FIRST_SID =NO_SID +1
};

