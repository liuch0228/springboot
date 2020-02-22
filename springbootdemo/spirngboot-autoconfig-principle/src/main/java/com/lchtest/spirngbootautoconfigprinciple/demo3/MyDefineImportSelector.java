package com.lchtest.spirngbootautoconfigprinciple.demo3;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyDefineImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
       // 数组元素是需要被装配的的对象
        return new String[]{TestService.class.getName()};
    }
}
