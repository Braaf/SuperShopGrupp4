/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.grupp4.super_shop.resttest;

import edu.chalmers.grupp4.super_shop.rest.ProductProxy;
import edu.chalmers.grupp4.super_shop.core.Product;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.junit.Test;

/**
 *
 * @author Braaf
 */
public class RestTest {
    
    @Test
    public void testMarshal() {
        Product p = new Product("JacketSuperDuper", 15.5, "jackets", 5, "SuperDuperJacket Mega Great", "./../resources/img/super_shop_clothes/super_pants/super_pants_blue.jpg" );
        ProductProxy pp = new ProductProxy(p);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ProductProxy.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(pp, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}

