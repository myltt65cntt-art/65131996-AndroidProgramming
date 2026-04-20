package thigk2.LATHITRAMY;

public class LandScape {
    String landImageFilename;
    String landCation;
    String url;
    public LandScape(String landImageFilename, String landCation,String url) {

        this.landImageFilename = landImageFilename;
        this.landCation = landCation;
        this.url = url;
    }

    public String getLandImageFilename() {
        return landImageFilename;
    }

    public void setLandImageFilename(String landImageFilename) {
        this.landImageFilename = landImageFilename;
    }

    public String getLandCation() {
        return landCation;
    }

    public void setLandCation(String landCation) {
        this.landCation = landCation;
    }
    public String getUrl() {
        return url;
    }
}