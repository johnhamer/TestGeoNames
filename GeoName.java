package jh.test;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlType;


/* ( <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<geonames>
<geoname>
<toponymName>Urnäsch</toponymName>
<name>Urnäsch</name>
<lat>47.31669</lat>
<lng>9.2795</lng>
<geonameId>2658223</geonameId>
<countryCode>CH</countryCode>
<countryName>Switzerland</countryName>
<fcl>P</fcl>
<fcode>PPL</fcode>
<distance>2.418</distance>
</geoname>
</geonames>
)  */ 


@XmlType(name = "geoname")
public class GeoName implements Serializable {
    public GeoName() {
        super();
    }
        
        private String toponymName = null;
        private String name = null;
        private BigDecimal lat;
        private BigDecimal lng; 
        private Long geonameId;
        private String countryCode = null;
        private String countryName = null;
        private String fcl = null;
        private String fcode = null;
        private BigDecimal distance;

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public BigDecimal getDistance() {
        return distance;
    }


    public void setToponymName(String toponymName) {
            this.toponymName = toponymName;
        }

        public String getToponymName() {
            return toponymName;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        
        public void setGeonameId(Long geonameId) {
            this.geonameId = geonameId;
        }

        public Long getGeonameId() {
            return geonameId;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setFcl(String fcl) {
            this.fcl = fcl;
        }

        public String getFcl() {
            return fcl;
        }

        public void setFcode(String fcode) {
            this.fcode = fcode;
        }

        public String getFcode() {
            return fcode;
        }

}
