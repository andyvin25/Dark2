//package com.marketplace.Util;
//
//import org.jspecify.annotations.Nullable;
//import org.springframework.aot.hint.MemberCategory;
//import org.springframework.aot.hint.RuntimeHints;
//import org.springframework.aot.hint.RuntimeHintsRegistrar;
//import org.springframework.aot.hint.TypeReference;
//
//public class JjwtRuntimeHints implements RuntimeHintsRegistrar {
//    @Override
//    public void registerHints(RuntimeHints hints, @Nullable ClassLoader classLoader) {
//        hints.reflection()
//                .registerType(TypeReference.of("io.jsonwebtoken.impl.DefaultJwtBuilder$Supplier"),
//                        MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS,
//                        MemberCategory.INVOKE_PUBLIC_METHODS,
//                        MemberCategory.ACCESS_DECLARED_FIELDS)
//                .registerType(TypeReference.of("io.jsonwebtoken.impl.DefaultJwtParserBuilder$Supplier"),
//                        MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS,
//                        MemberCategory.INVOKE_PUBLIC_METHODS,
//                        MemberCategory.ACCESS_DECLARED_FIELDS)
//                .registerType(TypeReference.of("io.jsonwebtoken.impl.DefaultJwtHeaderBuilder$Supplier"),
//
//                        )
//    }
//}
