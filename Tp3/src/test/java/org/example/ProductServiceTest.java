package org.example;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
public class ProductServiceTest {

    @Test
    public void testGetProduct_Success() {
        ProductApiClient productApiClientMock = mock(ProductApiClient.class);
       ProductService productService = new ProductService(productApiClientMock);
        Product P = new Product("1","produit1", 958);

        when(productApiClientMock.getProduct("2")).thenReturn(P);

           Product PR = productService.getProduct("2");

           verify(productApiClientMock).getProduct("2");

               assertEquals(P, PR);
    }
    @Test
    public void testGetProduct_IncompatibleDataFormat() {
       ProductApiClient productApiClientMock = mock(ProductApiClient.class);
       ProductService productService = new ProductService(productApiClientMock);
       when(productApiClientMock.getProduct(anyString())).thenReturn(null);

            Product P1 = productService.getProduct("invalidProductId");
        verify(productApiClientMock).getProduct("invalidProductId");
       assertNull(P1);
    }
    @Test
    public void testGetProduct_ApiCallFailure() {
    ProductApiClient productApiClientMock = mock(ProductApiClient.class);
            ProductService productService = new ProductService(productApiClientMock);
     when(productApiClientMock.getProduct(anyString())).thenThrow(new ApiException("API call failed"));
           ApiException exception = assertThrows(ApiException.class, () -> {
            productService.getProduct("anyProductId");
        });
     verify(productApiClientMock).getProduct("anyProductId");
        assertEquals("API call failed", exception.getMessage());
    }
  }
