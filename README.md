``
## 没有完全和黑马讲的一样,自定义了一些

# day01
## 1. 数据校验
因为使用if else 进行数据校验太麻烦并且不好管理,所以使用 validation 进行数据的校验

## 2. 自定义认证异常
在认证数据时发生错误使用异常的方法将错误信息抛出去并在全局异常处理中处理异常.


# day02
### 1. 使用拦截器 拦截没有认证的请求
### 2. 在前端访问index.html时 发送请求判断当时是否登录,如果没有登录就跳转到登录界面
> bug: <del>只要访问你的不是index.html 而是任意一个页面虽然能直接访问到页面</del>,
> <del>但是接口内容的数据还是访问不到. 尚未解决</del>
### 3. 在修改和新增 功能是没有进行数据的校验 
> bug: 对validate 的使用不是很熟练,以后有时间再来补充吧


# day03 
### 1. 解决了前端不登陆页面不跳转的问题
### 2. 直接使用session获取自动填充的值
> bug : 还是在提交数据的时候 数据没有进行校验,到最后统一处理


# day04  
### 1. 完成了菜品管理的增加删除修改和停售 启售 和批量删除
### 2. 前端修改传送的id 是categoryId 害我找了老半天
> bug: 数据的校验还是没有完成,最后再说吧