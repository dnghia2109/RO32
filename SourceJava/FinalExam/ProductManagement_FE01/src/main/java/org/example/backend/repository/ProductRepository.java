//package org.example.backend.repository;
//
//import org.example.entity.Category;
//import org.example.entity.Manufacturer;
//import org.example.entity.Product;
//import org.example.utills.JdbcUtils;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class ProductRepository {
//    JdbcUtils jdbcUtils;
//    ManufacturerRepository manufacturerRepository;
//    CategoryRepository categoryRepository;
//    public ProductRepository() {
//        jdbcUtils = new JdbcUtils();
//        manufacturerRepository = new ManufacturerRepository();
//        categoryRepository = new CategoryRepository();
//    }
//
//    // Lấy danh sách sản phẩm
//    public List<Product> getProduct(){
//        List<Manufacturer> manufacturerList = manufacturerRepository.getManufacturer();
//        List<Category> categoryList = categoryRepository.getCategory();
//
//        try {
//            List<Product> listPd = new ArrayList<>();
//            Connection connection = jdbcUtils.connect();
//            Statement st;
//            String sql = " SELECT * FROM ProductManagement.Product";
//            st = connection.createStatement();
//            ResultSet myRs =st.executeQuery(sql);
//            while(myRs.next()) {
//                Product p = new Product();
//                p.setProductId(myRs.getInt("ProductId"));
//                p.setRatingStar(myRs.getInt("RatingStar"));
//
//                for (Manufacturer manufacturer : manufacturerList) {
//                    if (manufacturer.getManufacturerId() == myRs.getInt("ManufacturerId")){
//                        p.setManufacturer(manufacturer);
//                    }
//                }
//
//                for (Category category : categoryList) {
//                    if (category.getCategoryID() == myRs.getInt("CategoryId")) {
//                        p.setCategory(category);
//                    }
//                }
//
//                p.setProductName(myRs.getString("ProductName"));
//                p.setProductPrice(myRs.getString("ProductPrice"));
//                p.setProductInfo(myRs.getString("ProductInfo"));
//                p.setProductDetail(myRs.getString("ProductDetail"));
//                p.setProductImageName(myRs.getString("ProductImageName"));
//                listPd.add(p);
//            }
//            jdbcUtils.disconnect();
//            return listPd;
//
//        }catch (Exception e) {
//            e.printStackTrace();
//            jdbcUtils.disconnect();
//            return null;
//        }
//    }
//
//    // Check xem sản phẩm có tồn tại hay ko
//    public boolean productIsExists(int id,List<Product>list) {
//        boolean check = false;
//        Iterator<Product> iterator = list.iterator();
//        while(iterator.hasNext()) {
//            Product product = iterator.next();
//            if(product.getProductId()==id) {
//                check = true;
//                break;
//            }
//        }
//        return check;
//    }
//
//    // Xóa sản phẩm theo id
//    public void xoaSanPham(int id) {
//        try {
//            List<Product> list = getProduct();
//            if (productIsExists(id, list)) {
//                Connection connection = jdbcUtils.connect();
//                String sql = " DELETE FROM ProductManagement.Product p WHERE p.ProductId = ?";
//                PreparedStatement preparedStatement = connection.prepareStatement(sql);
//                preparedStatement.setInt(1, id);
//                int check = preparedStatement.executeUpdate();
//                if (check == 0) {
//                    System.out.println("Lỗi xóa sản phẩm có id - " + id);
//                } else {
//                    System.out.println("Xóa thành công sản phẩm có id - " + id);
//                }
//            } else {
//                System.out.println("Không tim thấy sản phẩm có id -" + id);
//            }
//
//            jdbcUtils.disconnect();
//
//        }catch (Exception e) {
//            e.printStackTrace();
//            jdbcUtils.disconnect();
//
//        }
//    }
//}
