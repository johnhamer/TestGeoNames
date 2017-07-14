package jh.test;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "geonames" )
@XmlAccessorType(XmlAccessType.FIELD)
public class GeoNames implements Serializable {
    public GeoNames() {
        super();
    }
    
   // @XmlElementWrapper(name = "geonames")
    @XmlElement(name = "geoname")
    List<GeoName> geonames = new ArrayList<GeoName>();


    public void setGeonames(ArrayList<GeoName> geonames) {
        this.geonames = geonames;
    }

    public List<GeoName> getGeonames() {
        return geonames;
    }
}
