package it.unive.dais.po1.vehicles.autovehicles.fuel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

/**
 * This class represents a fuel type
 *
 * @since 1.0
 * @author Pietro Ferrara
 */
@XmlRootElement
@XmlType
public class FuelType implements Comparable<FuelType> {

    public FuelType() {
        this("", 0.0);
    }

    @XmlElement
    private final String type;

    public double getFuelCost() {
        return costPerLiter;
    }

    @XmlElement
    private double costPerLiter;

    @XmlAttribute
    private final double litresPerKmH;

    @Override
    public FuelType clone() {
        return new FuelType(type, costPerLiter, litresPerKmH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuelType fuelType = (FuelType) o;
        return Double.compare(fuelType.costPerLiter, costPerLiter) == 0 && Double.compare(fuelType.litresPerKmH, litresPerKmH) == 0 && Objects.equals(type, fuelType.type);
    }

    @Override
    public int hashCode() {
        return (int) costPerLiter;
    }

    /**
     * @return the number of litres per km/h of speed increase
     */
    public double getLitresPerKmH() {
        return this.litresPerKmH;
    }

    /**
     * This method sets the cost per liter to the given price if the change of the price is reasonable w.r.t. to the changes in the fuel market.
     * If the cost per liter is negative, it sets the price to zero.
     *
     * @param costPerLiter the new cost per liter of the current fuel type
     * @return true if and only if the cost per liter of the fuel is set to the given price after the execution of this method
     *
     * @requires NIENTE
     * @ensures costPerLiter < 0 => getCostPerLiter() = 0
     * @ensures costPerLiter >= 0 => Math.abs(this.costPerLiter-costPerLiter)/getCostPerLiter() < 0.20 => getCostPerLiter() = costPerLiter
     * @ensures costPerLiter >= 0 => Math.abs(this.costPerLiter-costPerLiter)/getCostPerLiter() >= 0.20 => ...
     */
    public boolean setCostPerLiter(double costPerLiter) {
        if(costPerLiter < 0) {
            this.costPerLiter = 0;
            return false;
        }
        else {
            double difference = Math.abs(this.costPerLiter-costPerLiter);
            double differencePercentage = difference/this.costPerLiter;
            if(differencePercentage < 0.20) {
                this.costPerLiter = costPerLiter;
                return true;
            }
            else return false;
        }
    }

    public FuelType(String t, double c) {
        this(t, c, 0.01);
    }

    /**
     *
     * @param type
     * @param costPerLiter
     * @param litresPerKmH
     */
    public FuelType(String type, double costPerLiter, double litresPerKmH) {
        this.type = type;
        this.costPerLiter = costPerLiter;
        this.litresPerKmH = litresPerKmH;
    }

    public boolean isCompatible(FuelTank tank) {
        return tank.getFuelType().equals(this.type);
    }

    @Override
    public int compareTo(FuelType o) {
        if(this.equals(o)) return 0;
        else if(! this.type.equals(o.type))
            return this.type.compareTo(o.type);
        else if(this.litresPerKmH!=o.litresPerKmH)
            return (int) (this.litresPerKmH-o.litresPerKmH);
        else return (int) (this.costPerLiter-o.costPerLiter);
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type+", cost " + costPerLiter + ", performance "+litresPerKmH;
    }


    public static void main(String[] args) throws JAXBException, IOException {
        //FuelType f = new FuelType("diesel", 0.015, 0.01);
        //marshal(f);
        FuelType f2 = unmarshall();
        System.out.println("ok");
    }
    static void marshal(FuelType fuelType)
            throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(FuelType.class);
        Marshaller mar= context.createMarshaller();
        mar.marshal(fuelType, new File("./fuelType.xml"));
    }
    static FuelType unmarshall()
            throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(FuelType.class);
        return (FuelType) context.createUnmarshaller()
                .unmarshal(new FileReader("./fuelType.xml"));
    }

}
