package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testConstructorWithoutId() {
        Product product = new Product("Laptop", 999.99);
        assertNull(product.getId());
        assertEquals("Laptop", product.getName());
        assertEquals(999.99, product.getPrice(), 0.001);
    }

    @Test
    public void testConstructorWithId() {
        Product product = new Product(1L, "Phone", 499.99);
        assertEquals(1L, product.getId());
        assertEquals("Phone", product.getName());
        assertEquals(499.99, product.getPrice(), 0.001);
    }

    @Test
    public void testSettersAndGetters() {
        Product product = new Product("Tablet", 299.99);
        product.setId(10L);
        product.setName("Updated Tablet");
        product.setPrice(199.99);

        assertEquals(10L, product.getId());
        assertEquals("Updated Tablet", product.getName());
        assertEquals(199.99, product.getPrice(), 0.001);
    }

    @Test
    public void testEqualsAndHashCode() {
        Product p1 = new Product(1L, "Mouse", 19.99);
        Product p2 = new Product(1L, "Mouse", 19.99);
        Product p3 = new Product(2L, "Keyboard", 29.99);

        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());

        assertNotEquals(p1, p3);
        assertNotEquals(p1.hashCode(), p3.hashCode());
    }

    @Test
    public void testToString() {
        Product product = new Product(3L, "Monitor", 149.49);
        String toString = product.toString();

        assertTrue(toString.contains("id=3"));
        assertTrue(toString.contains("name='Monitor'"));
        assertTrue(toString.contains("price=149.49"));
    }

    @Test
    public void testEqualsWithSameReference() {
        Product product = new Product(5L, "Camera", 299.99);
        assertEquals(product, product);
    }

    @Test
    public void testEqualsWithNull() {
        Product product = new Product(6L, "Speaker", 89.99);
        assertNotEquals(product, null);
    }

    @Test
    public void testEqualsWithDifferentClass() {
        Product product = new Product(7L, "Headphones", 59.99);
        assertNotEquals(product, "NotAProduct");
    }

    @Test
    public void testEqualsReturnsFalseForDifferentIds() {
        Product p1 = new Product(1L, "Product", 99.99);
        Product p2 = new Product(2L, "Product", 99.99);

        assertNotEquals(p1, p2);
    }


}
