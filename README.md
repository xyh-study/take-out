
## 没有完全和黑马讲的一样,自定义了一些

# day01
## 1. 数据校验
因为使用if else 进行数据校验太麻烦并且不好管理,所以使用 validation 进行数据的校验

## 2. 自定义认证异常
在认证数据时发生错误使用异常的方法将错误信息抛出去并在全局异常处理中处理异常.


# day02
### 1. 使用拦截器 拦截没有认证的请求
### 2. 在前端访问index.html时 发送请求判断当时是否登录,如果没有登录就跳转到登录界面
> bug: 只要访问你的不是index.html 而是任意一个页面虽然能直接访问到页面,
> 但是接口内容的数据还是访问不到. 尚未解决
### 3. 在修改和新增 功能是没有进行数据的校验 
> bug: 对validate 的使用不是很熟练,以后有时间再来补充吧