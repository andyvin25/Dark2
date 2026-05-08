package com.marketplace.Sub_Category_Management.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;

@RegisterReflectionForBinding
public record SubCategoryRequestDto(@JsonProperty("sub_category_name") String subCategoryName) {
}
