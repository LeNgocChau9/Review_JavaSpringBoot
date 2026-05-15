# Review_JavaSpringBoot
9:36PM 10/5/2026 start





Kho file jar Maven kéo về :https://mvnrepository.com/




cách viết tuân thủ 13 practice tài liệu link: https://florimond.dev/en/posts/2018/08/restful-api-design-13-best-practices-to-make-your-users-happy



- tài liệu sách dạy custom Exception: trang Exception javapoint


- tài liệu để fix lỗi bị lỗi sever những vẫn trả về 200 OK 
-@ControllerAdvice 
- link: https://zetcode.com/springboot/controlleradvice/

- phân biệt rõ lỗi 401 và 403 khác nhau chỗ nào ?

+ 401:Mặc dù tiêu chuẩn HTTP quy định "unauthorized" (không được phép), về mặt ngữ nghĩa, phản hồi này
có nghĩa là "unauthenticated" (chưa được xác thực). Tức là, máy khách phải
tự xác thực để nhận được phản hồi yêu cầu.

+ 401: Sai Tài Khoản đăng nhập hoặc quá thời hạn đăng nhập.


+ 403:Máy khách không có quyền truy cập vào nội dung; tức là,
việc truy cập là trái phép, vì vậy máy chủ từ chối cung cấp tài nguyên được yêu cầu.
Không giống như các trường hợp khác 401 Unauthorized, danh tính của máy khách được máy chủ biết đến.
Máy khách không có quyền truy cập vào nội dung; tức là, việc truy cập là trái phép,
vì vậy máy chủ từ chối cung cấp tài nguyên được yêu cầu. Không giống như các trường hợp khác 401 Unauthorized,
danh tính của máy khách được máy chủ biết đến.

+ 403: Đăng nhập thành công nhưng tài khoản đang truy cập 1 API chưa được phân quyền.


- Kết nối jdbc với my SQL

   //
   static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
  
    static final String USER = "root";
  
    static final String PASS = "123456";
  
  //


  + Tuân thủ nguyên tắc SOLID
  + link: https://www.educative.io/answers/what-are-the-solid-principles-in-java



+ Xây dựng mô hình 3 layer MVC

+ Code quá nhiều trong 1 file vi phạm nguyên tắc SOLID.
+ Người sau đọc rất tốn thời gian và khó debug.

<img width="1384" height="885" alt="image" src="https://github.com/user-attachments/assets/213988ac-72b7-45db-8a21-e0f75453f19c" />


+Presentation Layer => @Restcontroller => controller Class


+Business Logic Layer => @Service => service Class xử lý dữ liệu đầu ra theo yêu cầu của client



+Data Access Layer => @Repository => Repository Class

                                    (Entity map 1:1 DB) hứng dữ từ ResultSet trả ra

+Lấy dữ liệu lên : jdbc --> jpa --> Sring data jpa


ResultSet -> (JavaBean) Entity (map 1:1 với DB) -> Filter (layer Service)  -> DTO (model) -> View


+ update dữ liệu

View -> DTO(model) ->Filter (Service) -> Entity -> DB



