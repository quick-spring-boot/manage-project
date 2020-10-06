# Token 续期

- access_token: 用来正真请求的token
- refresh_token : 用来刷新 access_token


在正常请求时需要带入 access_token 

接口定义:
1. 获取 access_token
2. 刷新 access_token 

----
用户id 和 refresh token 和 access token


业务流程
1. 用户登录
    - 调用登录接口. 返回 
```json
{
 "user_info": {},
  "token_collection": {
      "access_token": "",
      "refresh_token":""
    }   
}
```
1. 用户登录调用后,拿到 token_collection 后存储在前端, 设置过期时间, 过期时间到了调用刷新token接口将信息再次存储
2. 在调用数据接口是使用 access_token 作为参数
