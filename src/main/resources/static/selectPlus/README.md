# selectplus

#### 项目介绍
基于layui框架的下拉框加强版，初始版本具备基础数据展现、异步加载、数据回调、异步返回数据自定义、默认选项等功能，支持单选和多选。内部使用 form 和 jQuery 模块。

#### 效果
![输入图片说明](https://images.gitee.com/uploads/images/2018/1119/005405_f2d5c829_1994789.gif "select.gif")

#### 使用
复制 selectPlus.js 文件到项目上，使用layui导入方式导入。[layui详细文档](https://www.layui.com/doc/)
简单使用如下，案例在demo文件夹。

```
 
    layui.config({
      base: '../../../layui_exts/selectPlus/'
    }).extend({
      test: 'selectPlus'
    }).use(['selectPlus', 'jquery'], function () {
      var $ = layui.$,
        selectPlus = layui.selectPlus;

      // 多选
      var test = selectPlus.render({
        el: '#test',
        data: [{
          "name": "vue",
          "id": 1,
          "text": "hello vue"
        }, {
          "name": "layui",
          "id": 2,
          "text": "hello layui"
        }, {
          "name": "react",
          "id": 3,
          "text": "hello react"
        }, {
          "name": "bootstrap",
          "id": 4,
          "text": "hello bootstrap"
        }, {
          "name": "element",
          "id": 5,
          "text": "hello element"
        }],
        valueName: "name",
        values: ['bootstrap', 'element'],
        valueSeparator: " --- "
      });

 ```
#### 详细参数

+ 基础参数

| 参数           | 类型         | 说明                           | 示例值/默认值 |
| -------------- | ------------ | ------------------------------ | ------------- |
| el             | string       | 指定容器                       | #dome         |
| type           | string       | 下拉框的类型（checkbox/radio） | checkbox      |
| valueSeparator | string       | 多选时，数据之间的分隔符       | /             |
| data           | array        | 直接赋值数据                   | []            |
| values         | array/string | 默认选中的值                   | layui         |

+ 数据时对象

| 参数           | 类型   | 说明                   | 示例值/默认值 |
| -------------- | ------ | ---------------------- | ------------- |
| valueName      | string | 选中时显示那个属性的值 | title         |
| label          | array  | 选项显示那些属性       | ['title']     |
| labelSeparator | string | 显示属性的连接符       | ---           |

+ 异步加载数据

| 参数        | 功能                                                                                          |
| ----------- | --------------------------------------------------------------------------------------------- |
| url         | 接口地址                                                                                      |
| method      | 接口http请求类型，默认：get                                                                   |
| where       | 参数，如：where: {token: 'sasasas', id: 123}                                                  |
| contentType | 发送到服务端的内容编码类型。如果你要发送 json 内容，可以设置：contentType: 'application/json' |
| headers     | 接口的请求头。如：headers: {token: 'sasasas'}                                                 |
| response    | 设置返回数据对象的某个属性的数据为下拉框的实际数据                                            |
| parseData   | 数据预解析回调函数，用于将返回的任意数据作为下拉框的数据                                      |


+ 方法

选择时触发事件，回调函数返回一个object参数，携带的成员如下：
```
//注：selectPlus是固定事件名，test是selectPlus原始容器的属性 lay-filter="对应的值"
 selectPlus.on('selectPlus(test)', function(obj){  


// 多选时
  console.log(obj.checked); //当前是否选中状态
  console.log(obj.values); //选中的数据
  console.log(obj.checkedData); //选中的相关数据
  console.log(obj.isAll); //是否是全选
  console.log(obj.ele); //点击的DOM 

// 单选时

  console.log(obj.value); //选中的数据
  console.log(obj.checkedData); //选中的相关数据
  console.log(obj.ele); //点击的DOM 
});
```

获取选中数据

```
var test = selectPlus.render({
        el: '#test',
        data: [{
          "name": "vue",
          "id": 1,
          "text": "hello vue"
        }, {
          "name": "layui",
          "id": 2,
          "text": "hello layui"
        }],
       });
var obj = test.getChecked();
 console.log(obj.value); //选中的数据
 console.log(obj.checkedData); //选中的相关数据
```
