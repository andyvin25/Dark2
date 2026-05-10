package com.marketplace.Config;

import org.jspecify.annotations.Nullable;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

public class AwtHints implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, @Nullable ClassLoader classLoader) {
        hints.resources().registerPattern("sun/awt/*");
        hints.resources().registerPattern("javax/imageio/*");
        hints.resources().registerPattern("java/awt/*");
    }
}
