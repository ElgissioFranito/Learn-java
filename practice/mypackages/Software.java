package mypackages;
public class Software {
    private String licence;
    private static int maxSoftware = 2;

    public Software(String licence) {
        if (maxSoftware > 0) {
            this.licence = licence;
            maxSoftware--;
            System.out.println("Il vous reste " + maxSoftware + " logiciels a ajouter");   
        } else {
         System.out.println("Limite atteinte pour creer des logiciels");   
        }
    }

    public String getLicence() {
        if (this.licence == null) {
            return "Pas de licence";
        }
        return this.licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    
}
