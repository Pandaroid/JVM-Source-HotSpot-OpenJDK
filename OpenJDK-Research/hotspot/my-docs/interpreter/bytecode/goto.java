goto 167goto[0x01cc36c0,0x01cc3970]688bytes

        0x01cc36c0:sub $0x4,%esp
        0x01cc36c3:fstps(%esp)
        0x01cc36c6:jmp 0x01cc36e4
        0x01cc36cb:sub $0x8,%esp
        0x01cc36ce:fstpl(%esp)
        0x01cc36d1:jmp 0x01cc36e4
        0x01cc36d6:push%edx
        0x01cc36d7:push%eax
        0x01cc36d8:jmp 0x01cc36e4
        0x01cc36dd:push%eax
        0x01cc36de:jmp 0x01cc36e4
        0x01cc36e3:push%eax

        0x01cc36e4:mov-0xc(%ebp),%ecx
        0x01cc36e7:movswl 0x1(%esi),%edx
        0x01cc36eb:bswap%edx
        0x01cc36ed:sar $0x10,%edx
        0x01cc36f0:add%edx,%esi
        0x01cc36f2:test%edx,%edx
        0x01cc36f4:jns 0x01cc37d3
        0x01cc36fa:mov 0x10(%ecx),%eax
        0x01cc36fd:test%eax,%eax
        0x01cc36ff:jne 0x01cc37b2
        0x01cc3705:push%edx
        0x01cc3706:push%ecx
        0x01cc3707:call 0x01cc3711
        0x01cc370c:jmp 0x01cc37a5
        0x01cc3711:push%ecx
        0x01cc3712:lea 0x8(%esp),%eax
        0x01cc3716:cmpl $0x0,-0x8(%ebp)
        0x01cc371d:je 0x01cc3734
        0x01cc3723:push $0x55310188
        0x01cc3728:call 0x01cc372d
        0x01cc372d:pusha
        0x01cc372e:call 0x54dedbf0
        0x01cc3733:hlt
        0x01cc3734:mov%esi,-0x1c(%ebp)
        0x01cc3737:mov%fs:0x0(,%eiz,1),%edi
        0x01cc373f:mov-0xc(%edi),%edi
        0x01cc3742:push%edi
        0x01cc3743:mov%ebp,0x144(%edi)
        0x01cc3749:mov%eax,0x13c(%edi)
        0x01cc374f:call 0x5505d720
        0x01cc3754:add $0x8,%esp
        0x01cc3757:push%eax
        0x01cc3758:mov%fs:0x0(,%eiz,1),%eax
        0x01cc3760:mov-0xc(%eax),%eax
        0x01cc3763:cmp%eax,%edi
        0x01cc3765:je 0x01cc377c
        ;;MacroAssembler::call_VM_base:rdi not callee saved?
        0x01cc376b:push $0x55312af0
        0x01cc3770:call 0x01cc3775
        0x01cc3775:pusha
        0x01cc3776:call 0x54dedbf0
        0x01cc377b:hlt
        0x01cc377c:pop%eax
        0x01cc377d:movl $0x0,0x13c(%edi)
        0x01cc3787:movl $0x0,0x144(%edi)
        0x01cc3791:cmpl $0x0,0x4(%edi)
        0x01cc3798:jne 0x01cb0340
        0x01cc379e:mov-0x1c(%ebp),%esi
        0x01cc37a1:mov-0x18(%ebp),%edi
        0x01cc37a4:ret
        0x01cc37a5:pop%ecx
        0x01cc37a6:pop%edx
        0x01cc37a7:mov 0x10(%ecx),%eax
        0x01cc37aa:test%eax,%eax
        0x01cc37ac:je 0x01cc37d3
        0x01cc37b2:mov 0x10(%ecx),%ecx
        0x01cc37b5:mov 0xc(%ecx),%eax
        0x01cc37b8:add $0x8,%eax
        0x01cc37bb:mov%eax,0xc(%ecx)
        0x01cc37be:mov 0x8(%ecx),%eax
        0x01cc37c1:and $0xfffffff8,%eax
        0x01cc37c4:add 0xc(%ecx),%eax
        0x01cc37c7:cmp 0x55627788,%eax
        0x01cc37cd:jae 0x01cc37dd
        0x01cc37d3:movzbl(%esi),%ebx
        0x01cc37d6:jmp*0x55629838(,%ebx,4)
        0x01cc37dd:neg%edx
        0x01cc37df:add%esi,%edx
        0x01cc37e1:call 0x01cc37eb
        0x01cc37e6:jmp 0x01cc387f
        0x01cc37eb:push%edx
        0x01cc37ec:lea 0x8(%esp),%eax
        0x01cc37f0:cmpl $0x0,-0x8(%ebp)
        0x01cc37f7:je 0x01cc380e
        0x01cc37fd:push $0x55310188
        0x01cc3802:call 0x01cc3807
        0x01cc3807:pusha
        0x01cc3808:call 0x54dedbf0
        0x01cc380d:hlt
        0x01cc380e:mov%esi,-0x1c(%ebp)
        0x01cc3811:mov%fs:0x0(,%eiz,1),%edi
        0x01cc3819:mov-0xc(%edi),%edi
        0x01cc381c:push%edi
        0x01cc381d:mov%ebp,0x144(%edi)
        0x01cc3823:mov%eax,0x13c(%edi)
        0x01cc3829:call 0x5505ce70
        0x01cc382e:add $0x8,%esp
        0x01cc3831:push%eax
        0x01cc3832:mov%fs:0x0(,%eiz,1),%eax
        0x01cc383a:mov-0xc(%eax),%eax
        0x01cc383d:cmp%eax,%edi
        0x01cc383f:je 0x01cc3856
        ;;MacroAssembler::call_VM_base:rdi not callee saved?
        0x01cc3845:push $0x55312af0
        0x01cc384a:call 0x01cc384f
        0x01cc384f:pusha
        0x01cc3850:call 0x54dedbf0
        0x01cc3855:hlt
        0x01cc3856:pop%eax
        0x01cc3857:movl $0x0,0x13c(%edi)
        0x01cc3861:movl $0x0,0x144(%edi)
        0x01cc386b:cmpl $0x0,0x4(%edi)
        0x01cc3872:jne 0x01cb0340
        0x01cc3878:mov-0x1c(%ebp),%esi
        0x01cc387b:mov-0x18(%ebp),%edi
        0x01cc387e:ret
        0x01cc387f:movzbl(%esi),%ebx
        0x01cc3882:test%eax,%eax
        0x01cc3884:je 0x01cc37d3
        0x01cc388a:mov 0x34(%eax),%ecx
        0x01cc388d:cmp $0xfffffffe,%ecx
        0x01cc3890:je 0x01cc37d3
        0x01cc3896:mov%eax,%ebx
        0x01cc3898:mov%fs:0x0(,%eiz,1),%ecx
        0x01cc38a0:mov-0xc(%ecx),%ecx
        0x01cc38a3:call 0x01cc38ad
        0x01cc38a8:jmp 0x01cc3940
        0x01cc38ad:lea 0x4(%esp),%eax
        0x01cc38b1:cmpl $0x0,-0x8(%ebp)
        0x01cc38b8:je 0x01cc38cf
        0x01cc38be:push $0x55310188
        0x01cc38c3:call 0x01cc38c8
        0x01cc38c8:pusha
        0x01cc38c9:call 0x54dedbf0
        0x01cc38ce:hlt
        0x01cc38cf:mov%esi,-0x1c(%ebp)
        0x01cc38d2:mov%fs:0x0(,%eiz,1),%edi
        0x01cc38da:mov-0xc(%edi),%edi
        0x01cc38dd:push%edi
        0x01cc38de:mov%ebp,0x144(%edi)
        0x01cc38e4:mov%eax,0x13c(%edi)
        0x01cc38ea:call 0x55217020
        0x01cc38ef:add $0x4,%esp
        0x01cc38f2:push%eax
        0x01cc38f3:mov%fs:0x0(,%eiz,1),%eax
        0x01cc38fb:mov-0xc(%eax),%eax
        0x01cc38fe:cmp%eax,%edi
        0x01cc3900:je 0x01cc3917
        ;;MacroAssembler::call_VM_base:rdi not callee saved?
        0x01cc3906:push $0x55312af0
        0x01cc390b:call 0x01cc3910
        0x01cc3910:pusha
        0x01cc3911:call 0x54dedbf0
        0x01cc3916:hlt
        0x01cc3917:pop%eax
        0x01cc3918:movl $0x0,0x13c(%edi)
        0x01cc3922:movl $0x0,0x144(%edi)
        0x01cc392c:cmpl $0x0,0x4(%edi)
        0x01cc3933:jne 0x01cb0340
        0x01cc3939:mov-0x1c(%ebp),%esi
        0x01cc393c:mov-0x18(%ebp),%edi
        0x01cc393f:ret
        0x01cc3940:mov%eax,%ecx
        0x01cc3942:mov-0x4(%ebp),%edx
        0x01cc3945:mov%ebp,%esp
        0x01cc3947:pop%ebp
        0x01cc3948:pop%edi
        0x01cc3949:mov%edx,%esp
        0x01cc394b:and $0xfffffff0,%esp
        0x01cc394e:push%edi
        0x01cc394f:jmp*0x54(%ebx)
        0x01cc3952:push $0x552fd97c
        0x01cc3957:call 0x01cc395c
        0x01cc395c:pusha
        0x01cc395d:call 0x54dedbf0
        0x01cc3962:hlt
        0x01cc3963:nop
        0x01cc3964:int3
        0x01cc3965:int3
        0x01cc3966:int3
        0x01cc3967:int3
        0x01cc3968:int3
        0x01cc3969:int3
        0x01cc396a:int3
        0x01cc396b:int3
        0x01cc396c:int3
        0x01cc396d:int3
        0x01cc396e:int3
        0x01cc396f:int3   

