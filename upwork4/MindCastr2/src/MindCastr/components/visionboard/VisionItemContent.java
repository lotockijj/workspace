package MindCastr.components.visionboard;

public class VisionItemContent {
    
    public final ContentType type;
    public final String subliminalContent;
    
    public VisionItemContent(ContentType type, String subliminalContent) {
        if(type == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if(subliminalContent == null) {
            throw new IllegalArgumentException("subliminalContent cannot be null.");
        }
        this.type = type;
        this.subliminalContent = subliminalContent;
    }
    
    public static enum ContentType {
        TEXT("txt:"),
        IMAGE_URL("img:");
        
        public final String prefixExtension;
        
        private ContentType(String prefixExtension) {
            this.prefixExtension = prefixExtension;
        }
        
        public static ContentType fromString(String string) {
            if(string != null) {
                for(ContentType contentType : ContentType.values()) {
                    if(contentType.prefixExtension.equals(string)) {
                        return contentType;
                    }
                }
            }
            assert(false);
            return null;
        }
    }
    
    @Override
    public String toString() {
        return type.prefixExtension + subliminalContent;
    }
    
    public static VisionItemContent fromString(String string) {
        if(string == null || string.length() <= 4) {
            return null;
        }
        String prefix = string.substring(0, 4);
        ContentType contentType = ContentType.fromString(prefix);
        assert(contentType != null);
        String subliminalText = string.substring(4);
        return new VisionItemContent(contentType, subliminalText);
    }
    
}
