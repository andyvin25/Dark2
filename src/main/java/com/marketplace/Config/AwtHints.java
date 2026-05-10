package com.marketplace.Config;

import org.jspecify.annotations.Nullable;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.TypeReference;

public class AwtHints implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, @Nullable ClassLoader classLoader) {

        hints.reflection().registerType(
                TypeReference.of("com.sun.imageio.plugins.jpeg.JPEGImageReaderSpi"),
                MemberCategory.INVOKE_DECLARED_CONSTRUCTORS,
                MemberCategory.INVOKE_DECLARED_METHODS
        );
        hints.reflection().registerType(
                TypeReference.of("com.sun.imageio.plugins.jpeg.JPEGImageWriterSpi"),
                MemberCategory.INVOKE_DECLARED_CONSTRUCTORS,
                MemberCategory.INVOKE_DECLARED_METHODS
        );
        hints.reflection().registerType(
                TypeReference.of("com.sun.imageio.plugins.png.PNGImageReaderSpi"),
                MemberCategory.INVOKE_DECLARED_CONSTRUCTORS,
                MemberCategory.INVOKE_DECLARED_METHODS
        );

        // Resources
        hints.resources().registerPattern("META-INF/services/javax.imageio.spi.ImageReaderSpi");
        hints.resources().registerPattern("META-INF/services/javax.imageio.spi.ImageWriterSpi");
    }
}
