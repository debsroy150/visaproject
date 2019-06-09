# visaproject

Catalog API -

API : http://localhost:8080/product/all

SAMPLE RESULT : [{"id":1001,"name":"Product 1","desc":"Product 1 Description","amount":50.0,"quantity":100},{"id":1002,"name":"Product 2","desc":"Product 2 Description","amount":150.0,"quantity":200},{"id":1003,"name":"Product 3","desc":"Product 3 Description","amount":250.0,"quantity":0}]

API : http://localhost:8080/product/1001

SAMPLE RESULT : {"id":1001,"name":"Product 1","desc":"Product 1 Description","amount":50.0,"quantity":100}

Order API -

API : http://localhost:8081/order/create?_emailId=test@test.com

SAMPLE RESULT : 1

API : http://localhost:8081/order/get?_emailId=test@test.com

SAMPLE RESULT : {"orderId":1,"orderItems":[],"orderTotal":0.0,"status":"P","emailId":"test@test.com"}

API : http://localhost:8081/order/addItem?_orderId=1&_productId=1001&_quantity=20&_item_total=245&_orderTotal=245

SAMPLE RESULT : 1001

API : http://localhost:8082/payment/submitSuccess?_orderId=1&_mCard=1111&_amount=245

SAMPLE RESULT : 

API : http://localhost:8082/payment/submitFailure?_orderId=1&_mCard=1111&_amount=245_reason=Card_Invalid

SAMPLE RESULT : 
