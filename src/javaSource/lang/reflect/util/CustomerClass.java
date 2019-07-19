package javaSource.lang.reflect.util;

@CustomAnnotation(name = "wgx", value = "qaz")
public class CustomerClass {
    public String publicFiled;

    private String privateField;

    @CustomAnnotation(name = "annotationField")
    private String annotationField;

    public String getPublicFiled() {
        return publicFiled;
    }

    public void setPublicFiled(String publicFiled) {
        this.publicFiled = publicFiled;
    }

    public String getPrivateField() {
        return privateField;
    }

    public void setPrivateField(String privateField) {
        this.privateField = privateField;
    }

    public String getAnnotationField() {
        return annotationField;
    }

    public void setAnnotationField(String annotationField) {
        this.annotationField = annotationField;
    }
}
