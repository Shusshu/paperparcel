package nz.bradcampbell.dataparcel.internal.properties;

import android.support.annotation.Nullable;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.ParameterSpec;
import nz.bradcampbell.dataparcel.internal.Property;

public class StringProperty extends Property {
  public StringProperty(Property.Type propertyType, boolean isNullable, String name) {
    super(propertyType, isNullable, name);
  }

  @Override protected void readFromParcelInner(CodeBlock.Builder block, ParameterSpec in, @Nullable FieldSpec classLoader) {
    block.addStatement("$N = $N.readString()", getName(), in);
  }

  @Override protected void writeToParcelInner(CodeBlock.Builder block, ParameterSpec dest, String variableName) {
    block.addStatement("$N.writeString($N)", dest, variableName);
  }
}
