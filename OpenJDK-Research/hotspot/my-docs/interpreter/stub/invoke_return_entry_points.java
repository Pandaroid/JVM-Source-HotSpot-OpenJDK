invoke return entry points[0x07f03bf0,0x07f041f0]1536bytes

        // Restore stack bottom in case i2c adjusted stack
        0x07f03bf0:mov-0x8(%ebp),%esp
        // and NULL it as marker that rsp is now tos until next java call
        0x07f03bf3:movl $0x0,-0x8(%ebp)

        0x07f03bfa:mov-0x1c(%ebp),%esi //restore_bcp
        0x07f03bfd:mov-0x18(%ebp),%edi //restore_locals

        //get_cache_and_index_at_bcp
        0x07f03c00:movzwl 0x1(%esi),%ecx
        0x07f03c04:mov-0x14(%ebp),%ebx
        0x07f03c07:shl $0x2,%ecx

        0x07f03c0a:mov 0x14(%ebx,%ecx,4),%ebx //ConstantPoolCacheEntry::_flags
        0x07f03c0e:and $0xff,%ebx //parameter size
        0x07f03c14:lea(%esp,%ebx,4),%esp //栈顶指针移动方法参数前的位置

        //dispatch_next
        0x07f03c17:movzbl 0x3(%esi),%ebx //取下一条字节码
        0x07f03c1b:add $0x3,%esi //invoke指令都占3个字节
        0x07f03c1e:jmp*0x55028448(,%ebx,4)

        //下面的都跟上面的有点类似

        0x07f03c25:mov-0x8(%ebp),%esp
        0x07f03c28:movl $0x0,-0x8(%ebp)
        0x07f03c2f:mov-0x1c(%ebp),%esi
        0x07f03c32:mov-0x18(%ebp),%edi
        0x07f03c35:movzwl 0x1(%esi),%ecx
        0x07f03c39:mov-0x14(%ebp),%ebx
        0x07f03c3c:shl $0x2,%ecx
        0x07f03c3f:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f03c43:and $0xff,%ebx
        0x07f03c49:lea(%esp,%ebx,4),%esp
        0x07f03c4c:movzbl 0x5(%esi),%ebx
        0x07f03c50:add $0x5,%esi
        0x07f03c53:jmp*0x55028448(,%ebx,4)

        0x07f03c5a:mov-0x8(%ebp),%esp
        0x07f03c5d:movl $0x0,-0x8(%ebp)
        0x07f03c64:mov-0x1c(%ebp),%esi
        0x07f03c67:mov-0x18(%ebp),%edi
        0x07f03c6a:mov 0x1(%esi),%ecx
        0x07f03c6d:not%ecx
        0x07f03c6f:mov-0x14(%ebp),%ebx
        0x07f03c72:shl $0x2,%ecx
        0x07f03c75:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f03c79:and $0xff,%ebx
        0x07f03c7f:lea(%esp,%ebx,4),%esp
        0x07f03c82:movzbl 0x5(%esi),%ebx
        0x07f03c86:add $0x5,%esi
        0x07f03c89:jmp*0x55028448(,%ebx,4)

        0x07f03c90:mov-0x8(%ebp),%esp
        0x07f03c93:movl $0x0,-0x8(%ebp)
        0x07f03c9a:mov-0x1c(%ebp),%esi
        0x07f03c9d:mov-0x18(%ebp),%edi
        0x07f03ca0:movzwl 0x1(%esi),%ecx
        0x07f03ca4:mov-0x14(%ebp),%ebx
        0x07f03ca7:shl $0x2,%ecx
        0x07f03caa:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f03cae:and $0xff,%ebx
        0x07f03cb4:lea(%esp,%ebx,4),%esp
        0x07f03cb7:movzbl 0x3(%esi),%ebx
        0x07f03cbb:add $0x3,%esi
        0x07f03cbe:jmp*0x55028448(,%ebx,4)

        0x07f03cc5:mov-0x8(%ebp),%esp
        0x07f03cc8:movl $0x0,-0x8(%ebp)
        0x07f03ccf:mov-0x1c(%ebp),%esi
        0x07f03cd2:mov-0x18(%ebp),%edi
        0x07f03cd5:movzwl 0x1(%esi),%ecx
        0x07f03cd9:mov-0x14(%ebp),%ebx
        0x07f03cdc:shl $0x2,%ecx
        0x07f03cdf:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f03ce3:and $0xff,%ebx
        0x07f03ce9:lea(%esp,%ebx,4),%esp
        0x07f03cec:movzbl 0x5(%esi),%ebx
        0x07f03cf0:add $0x5,%esi
        0x07f03cf3:jmp*0x55028448(,%ebx,4)

        0x07f03cfa:mov-0x8(%ebp),%esp
        0x07f03cfd:movl $0x0,-0x8(%ebp)
        0x07f03d04:mov-0x1c(%ebp),%esi
        0x07f03d07:mov-0x18(%ebp),%edi
        0x07f03d0a:mov 0x1(%esi),%ecx
        0x07f03d0d:not%ecx
        0x07f03d0f:mov-0x14(%ebp),%ebx
        0x07f03d12:shl $0x2,%ecx
        0x07f03d15:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f03d19:and $0xff,%ebx
        0x07f03d1f:lea(%esp,%ebx,4),%esp
        0x07f03d22:movzbl 0x5(%esi),%ebx
        0x07f03d26:add $0x5,%esi
        0x07f03d29:jmp*0x55028448(,%ebx,4)

        0x07f03d30:mov-0x8(%ebp),%esp
        0x07f03d33:movl $0x0,-0x8(%ebp)
        0x07f03d3a:mov-0x1c(%ebp),%esi
        0x07f03d3d:mov-0x18(%ebp),%edi
        0x07f03d40:movzwl 0x1(%esi),%ecx
        0x07f03d44:mov-0x14(%ebp),%ebx
        0x07f03d47:shl $0x2,%ecx
        0x07f03d4a:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f03d4e:and $0xff,%ebx
        0x07f03d54:lea(%esp,%ebx,4),%esp
        0x07f03d57:movzbl 0x3(%esi),%ebx
        0x07f03d5b:add $0x3,%esi
        0x07f03d5e:jmp*0x55028448(,%ebx,4)

        0x07f03d65:mov-0x8(%ebp),%esp
        0x07f03d68:movl $0x0,-0x8(%ebp)
        0x07f03d6f:mov-0x1c(%ebp),%esi
        0x07f03d72:mov-0x18(%ebp),%edi
        0x07f03d75:movzwl 0x1(%esi),%ecx
        0x07f03d79:mov-0x14(%ebp),%ebx
        0x07f03d7c:shl $0x2,%ecx
        0x07f03d7f:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f03d83:and $0xff,%ebx
        0x07f03d89:lea(%esp,%ebx,4),%esp
        0x07f03d8c:movzbl 0x5(%esi),%ebx
        0x07f03d90:add $0x5,%esi
        0x07f03d93:jmp*0x55028448(,%ebx,4)

        0x07f03d9a:mov-0x8(%ebp),%esp
        0x07f03d9d:movl $0x0,-0x8(%ebp)
        0x07f03da4:mov-0x1c(%ebp),%esi
        0x07f03da7:mov-0x18(%ebp),%edi
        0x07f03daa:mov 0x1(%esi),%ecx
        0x07f03dad:not%ecx
        0x07f03daf:mov-0x14(%ebp),%ebx
        0x07f03db2:shl $0x2,%ecx
        0x07f03db5:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f03db9:and $0xff,%ebx
        0x07f03dbf:lea(%esp,%ebx,4),%esp
        0x07f03dc2:movzbl 0x5(%esi),%ebx
        0x07f03dc6:add $0x5,%esi
        0x07f03dc9:jmp*0x55028448(,%ebx,4)

        0x07f03dd0:mov-0x8(%ebp),%esp
        0x07f03dd3:movl $0x0,-0x8(%ebp)
        0x07f03dda:mov-0x1c(%ebp),%esi
        0x07f03ddd:mov-0x18(%ebp),%edi
        0x07f03de0:movzwl 0x1(%esi),%ecx
        0x07f03de4:mov-0x14(%ebp),%ebx
        0x07f03de7:shl $0x2,%ecx
        0x07f03dea:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f03dee:and $0xff,%ebx
        0x07f03df4:lea(%esp,%ebx,4),%esp
        0x07f03df7:movzbl 0x3(%esi),%ebx
        0x07f03dfb:add $0x3,%esi
        0x07f03dfe:jmp*0x55028448(,%ebx,4)

        0x07f03e05:mov-0x8(%ebp),%esp
        0x07f03e08:movl $0x0,-0x8(%ebp)
        0x07f03e0f:mov-0x1c(%ebp),%esi
        0x07f03e12:mov-0x18(%ebp),%edi
        0x07f03e15:movzwl 0x1(%esi),%ecx
        0x07f03e19:mov-0x14(%ebp),%ebx
        0x07f03e1c:shl $0x2,%ecx
        0x07f03e1f:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f03e23:and $0xff,%ebx
        0x07f03e29:lea(%esp,%ebx,4),%esp
        0x07f03e2c:movzbl 0x5(%esi),%ebx
        0x07f03e30:add $0x5,%esi
        0x07f03e33:jmp*0x55028448(,%ebx,4)

        0x07f03e3a:mov-0x8(%ebp),%esp
        0x07f03e3d:movl $0x0,-0x8(%ebp)
        0x07f03e44:mov-0x1c(%ebp),%esi
        0x07f03e47:mov-0x18(%ebp),%edi
        0x07f03e4a:mov 0x1(%esi),%ecx
        0x07f03e4d:not%ecx
        0x07f03e4f:mov-0x14(%ebp),%ebx
        0x07f03e52:shl $0x2,%ecx
        0x07f03e55:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f03e59:and $0xff,%ebx
        0x07f03e5f:lea(%esp,%ebx,4),%esp
        0x07f03e62:movzbl 0x5(%esi),%ebx
        0x07f03e66:add $0x5,%esi
        0x07f03e69:jmp*0x55028448(,%ebx,4)

        0x07f03e70:mov-0x8(%ebp),%esp
        0x07f03e73:movl $0x0,-0x8(%ebp)
        0x07f03e7a:mov-0x1c(%ebp),%esi
        0x07f03e7d:mov-0x18(%ebp),%edi
        0x07f03e80:movzwl 0x1(%esi),%ecx
        0x07f03e84:mov-0x14(%ebp),%ebx
        0x07f03e87:shl $0x2,%ecx
        0x07f03e8a:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f03e8e:and $0xff,%ebx
        0x07f03e94:lea(%esp,%ebx,4),%esp
        0x07f03e97:movzbl 0x3(%esi),%ebx
        0x07f03e9b:add $0x3,%esi
        0x07f03e9e:jmp*0x55028848(,%ebx,4)

        0x07f03ea5:mov-0x8(%ebp),%esp
        0x07f03ea8:movl $0x0,-0x8(%ebp)
        0x07f03eaf:mov-0x1c(%ebp),%esi
        0x07f03eb2:mov-0x18(%ebp),%edi
        0x07f03eb5:movzwl 0x1(%esi),%ecx
        0x07f03eb9:mov-0x14(%ebp),%ebx
        0x07f03ebc:shl $0x2,%ecx
        0x07f03ebf:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f03ec3:and $0xff,%ebx
        0x07f03ec9:lea(%esp,%ebx,4),%esp
        0x07f03ecc:movzbl 0x5(%esi),%ebx
        0x07f03ed0:add $0x5,%esi
        0x07f03ed3:jmp*0x55028848(,%ebx,4)

        0x07f03eda:mov-0x8(%ebp),%esp
        0x07f03edd:movl $0x0,-0x8(%ebp)
        0x07f03ee4:mov-0x1c(%ebp),%esi
        0x07f03ee7:mov-0x18(%ebp),%edi
        0x07f03eea:mov 0x1(%esi),%ecx
        0x07f03eed:not%ecx
        0x07f03eef:mov-0x14(%ebp),%ebx
        0x07f03ef2:shl $0x2,%ecx
        0x07f03ef5:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f03ef9:and $0xff,%ebx
        0x07f03eff:lea(%esp,%ebx,4),%esp
        0x07f03f02:movzbl 0x5(%esi),%ebx
        0x07f03f06:add $0x5,%esi
        0x07f03f09:jmp*0x55028848(,%ebx,4)

        0x07f03f10:sub $0x4,%esp
        0x07f03f13:movss%xmm0,(%esp)
        0x07f03f18:flds(%esp)
        0x07f03f1b:add $0x4,%esp
        0x07f03f1e:mov-0x8(%ebp),%esp
        0x07f03f21:movl $0x0,-0x8(%ebp)
        0x07f03f28:mov-0x1c(%ebp),%esi
        0x07f03f2b:mov-0x18(%ebp),%edi
        0x07f03f2e:movzwl 0x1(%esi),%ecx
        0x07f03f32:mov-0x14(%ebp),%ebx
        0x07f03f35:shl $0x2,%ecx
        0x07f03f38:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f03f3c:and $0xff,%ebx
        0x07f03f42:lea(%esp,%ebx,4),%esp
        0x07f03f45:movzbl 0x3(%esi),%ebx
        0x07f03f49:add $0x3,%esi
        0x07f03f4c:jmp*0x55028c48(,%ebx,4)

        0x07f03f53:sub $0x4,%esp
        0x07f03f56:movss%xmm0,(%esp)
        0x07f03f5b:flds(%esp)
        0x07f03f5e:add $0x4,%esp
        0x07f03f61:mov-0x8(%ebp),%esp
        0x07f03f64:movl $0x0,-0x8(%ebp)
        0x07f03f6b:mov-0x1c(%ebp),%esi
        0x07f03f6e:mov-0x18(%ebp),%edi
        0x07f03f71:movzwl 0x1(%esi),%ecx
        0x07f03f75:mov-0x14(%ebp),%ebx
        0x07f03f78:shl $0x2,%ecx
        0x07f03f7b:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f03f7f:and $0xff,%ebx
        0x07f03f85:lea(%esp,%ebx,4),%esp
        0x07f03f88:movzbl 0x5(%esi),%ebx
        0x07f03f8c:add $0x5,%esi
        0x07f03f8f:jmp*0x55028c48(,%ebx,4)

        0x07f03f96:sub $0x4,%esp
        0x07f03f99:movss%xmm0,(%esp)
        0x07f03f9e:flds(%esp)
        0x07f03fa1:add $0x4,%esp
        0x07f03fa4:mov-0x8(%ebp),%esp
        0x07f03fa7:movl $0x0,-0x8(%ebp)
        0x07f03fae:mov-0x1c(%ebp),%esi
        0x07f03fb1:mov-0x18(%ebp),%edi
        0x07f03fb4:mov 0x1(%esi),%ecx
        0x07f03fb7:not%ecx
        0x07f03fb9:mov-0x14(%ebp),%ebx
        0x07f03fbc:shl $0x2,%ecx
        0x07f03fbf:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f03fc3:and $0xff,%ebx
        0x07f03fc9:lea(%esp,%ebx,4),%esp
        0x07f03fcc:movzbl 0x5(%esi),%ebx
        0x07f03fd0:add $0x5,%esi
        0x07f03fd3:jmp*0x55028c48(,%ebx,4)

        0x07f03fda:sub $0x8,%esp
        0x07f03fdd:movsd%xmm0,(%esp)
        0x07f03fe2:fldl(%esp)
        0x07f03fe5:add $0x8,%esp
        0x07f03fe8:mov-0x8(%ebp),%esp
        0x07f03feb:movl $0x0,-0x8(%ebp)
        0x07f03ff2:mov-0x1c(%ebp),%esi
        0x07f03ff5:mov-0x18(%ebp),%edi
        0x07f03ff8:movzwl 0x1(%esi),%ecx
        0x07f03ffc:mov-0x14(%ebp),%ebx
        0x07f03fff:shl $0x2,%ecx
        0x07f04002:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f04006:and $0xff,%ebx
        0x07f0400c:lea(%esp,%ebx,4),%esp
        0x07f0400f:movzbl 0x3(%esi),%ebx
        0x07f04013:add $0x3,%esi
        0x07f04016:jmp*0x55029048(,%ebx,4)

        0x07f0401d:sub $0x8,%esp
        0x07f04020:movsd%xmm0,(%esp)
        0x07f04025:fldl(%esp)
        0x07f04028:add $0x8,%esp
        0x07f0402b:mov-0x8(%ebp),%esp
        0x07f0402e:movl $0x0,-0x8(%ebp)
        0x07f04035:mov-0x1c(%ebp),%esi
        0x07f04038:mov-0x18(%ebp),%edi
        0x07f0403b:movzwl 0x1(%esi),%ecx
        0x07f0403f:mov-0x14(%ebp),%ebx
        0x07f04042:shl $0x2,%ecx
        0x07f04045:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f04049:and $0xff,%ebx
        0x07f0404f:lea(%esp,%ebx,4),%esp
        0x07f04052:movzbl 0x5(%esi),%ebx
        0x07f04056:add $0x5,%esi
        0x07f04059:jmp*0x55029048(,%ebx,4)

        0x07f04060:sub $0x8,%esp
        0x07f04063:movsd%xmm0,(%esp)
        0x07f04068:fldl(%esp)
        0x07f0406b:add $0x8,%esp
        0x07f0406e:mov-0x8(%ebp),%esp
        0x07f04071:movl $0x0,-0x8(%ebp)
        0x07f04078:mov-0x1c(%ebp),%esi
        0x07f0407b:mov-0x18(%ebp),%edi
        0x07f0407e:mov 0x1(%esi),%ecx
        0x07f04081:not%ecx
        0x07f04083:mov-0x14(%ebp),%ebx
        0x07f04086:shl $0x2,%ecx
        0x07f04089:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f0408d:and $0xff,%ebx
        0x07f04093:lea(%esp,%ebx,4),%esp
        0x07f04096:movzbl 0x5(%esi),%ebx
        0x07f0409a:add $0x5,%esi
        0x07f0409d:jmp*0x55029048(,%ebx,4)

        0x07f040a4:mov-0x8(%ebp),%esp
        0x07f040a7:movl $0x0,-0x8(%ebp)
        0x07f040ae:mov-0x1c(%ebp),%esi
        0x07f040b1:mov-0x18(%ebp),%edi
        0x07f040b4:movzwl 0x1(%esi),%ecx
        0x07f040b8:mov-0x14(%ebp),%ebx
        0x07f040bb:shl $0x2,%ecx
        0x07f040be:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f040c2:and $0xff,%ebx
        0x07f040c8:lea(%esp,%ebx,4),%esp
        0x07f040cb:movzbl 0x3(%esi),%ebx
        0x07f040cf:add $0x3,%esi
        0x07f040d2:jmp*0x55029448(,%ebx,4)

        0x07f040d9:mov-0x8(%ebp),%esp
        0x07f040dc:movl $0x0,-0x8(%ebp)
        0x07f040e3:mov-0x1c(%ebp),%esi
        0x07f040e6:mov-0x18(%ebp),%edi
        0x07f040e9:movzwl 0x1(%esi),%ecx
        0x07f040ed:mov-0x14(%ebp),%ebx
        0x07f040f0:shl $0x2,%ecx
        0x07f040f3:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f040f7:and $0xff,%ebx
        0x07f040fd:lea(%esp,%ebx,4),%esp
        0x07f04100:movzbl 0x5(%esi),%ebx
        0x07f04104:add $0x5,%esi
        0x07f04107:jmp*0x55029448(,%ebx,4)

        0x07f0410e:mov-0x8(%ebp),%esp
        0x07f04111:movl $0x0,-0x8(%ebp)
        0x07f04118:mov-0x1c(%ebp),%esi
        0x07f0411b:mov-0x18(%ebp),%edi
        0x07f0411e:mov 0x1(%esi),%ecx
        0x07f04121:not%ecx
        0x07f04123:mov-0x14(%ebp),%ebx
        0x07f04126:shl $0x2,%ecx
        0x07f04129:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f0412d:and $0xff,%ebx
        0x07f04133:lea(%esp,%ebx,4),%esp
        0x07f04136:movzbl 0x5(%esi),%ebx
        0x07f0413a:add $0x5,%esi
        0x07f0413d:jmp*0x55029448(,%ebx,4)

        0x07f04144:mov-0x8(%ebp),%esp
        0x07f04147:movl $0x0,-0x8(%ebp)
        0x07f0414e:mov-0x1c(%ebp),%esi
        0x07f04151:mov-0x18(%ebp),%edi
        0x07f04154:movzwl 0x1(%esi),%ecx
        0x07f04158:mov-0x14(%ebp),%ebx
        0x07f0415b:shl $0x2,%ecx
        0x07f0415e:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f04162:and $0xff,%ebx
        0x07f04168:lea(%esp,%ebx,4),%esp
        0x07f0416b:movzbl 0x3(%esi),%ebx
        0x07f0416f:add $0x3,%esi
        0x07f04172:jmp*0x55029848(,%ebx,4)

        0x07f04179:mov-0x8(%ebp),%esp
        0x07f0417c:movl $0x0,-0x8(%ebp)
        0x07f04183:mov-0x1c(%ebp),%esi
        0x07f04186:mov-0x18(%ebp),%edi
        0x07f04189:movzwl 0x1(%esi),%ecx
        0x07f0418d:mov-0x14(%ebp),%ebx
        0x07f04190:shl $0x2,%ecx
        0x07f04193:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f04197:and $0xff,%ebx
        0x07f0419d:lea(%esp,%ebx,4),%esp
        0x07f041a0:movzbl 0x5(%esi),%ebx
        0x07f041a4:add $0x5,%esi
        0x07f041a7:jmp*0x55029848(,%ebx,4)

        0x07f041ae:mov-0x8(%ebp),%esp
        0x07f041b1:movl $0x0,-0x8(%ebp)
        0x07f041b8:mov-0x1c(%ebp),%esi
        0x07f041bb:mov-0x18(%ebp),%edi
        0x07f041be:mov 0x1(%esi),%ecx
        0x07f041c1:not%ecx
        0x07f041c3:mov-0x14(%ebp),%ebx
        0x07f041c6:shl $0x2,%ecx
        0x07f041c9:mov 0x14(%ebx,%ecx,4),%ebx
        0x07f041cd:and $0xff,%ebx
        0x07f041d3:lea(%esp,%ebx,4),%esp
        0x07f041d6:movzbl 0x5(%esi),%ebx
        0x07f041da:add $0x5,%esi
        0x07f041dd:jmp*0x55029848(,%ebx,4)

        0x07f041e4:int3
        0x07f041e5:int3
        0x07f041e6:int3
        0x07f041e7:int3
        0x07f041e8:int3
        0x07f041e9:int3
        0x07f041ea:int3
        0x07f041eb:int3
        0x07f041ec:int3
        0x07f041ed:int3
        0x07f041ee:int3
        0x07f041ef:int3   
