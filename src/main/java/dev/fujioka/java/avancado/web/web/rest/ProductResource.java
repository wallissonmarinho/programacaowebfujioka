package dev.fujioka.java.avancado.web.web.rest;

import dev.fujioka.java.avancado.web.domain.Product;
import dev.fujioka.java.avancado.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<Product> getProductList() {
        return productService.findAll();
    }


    @PostMapping("/product")
    public ResponseEntity<Product> save(
            @RequestBody Product product) {

        product = productService.save(product).get();

        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/product")
    public ResponseEntity<Product> update(
            @RequestBody Product product) {

        product = productService.save(product).get();

        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/product")
    public ResponseEntity<String> delete(
            @RequestBody Product product) {

        productService.delete(product);
        return ResponseEntity.ok().body("Product excluded " + product.getId());
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Long id){
    	return productService.buscarProdutoPorID(id);
    }
    
    @GetMapping("/product/name/{name}")
    public List<Product> getProductListByname(@PathVariable String name){
    	return productService.acharProductByName(name);
    }
    @GetMapping("/product/substring/{string}")
    public List<Product> getProductBySubstring(@PathVariable String string){
    	return productService.acharProductBySubstring(string);
    }

    @GetMapping("/product/dell")
    public String getProductDell(){
    	Product product = productService.acharProductDell();
		return ("Product name :" + product.getName());
    }

}
