layui.use(['selectPlus', 'jquery'], function () {
    var $ = layui.$,
        selectPlus = layui.selectPlus;


    // 单选
    var a = selectPlus.render({
        el: '#test1',
        url: "data.json",
        parseData: function (res) {
            return res.data;
        },
        type: "radio",
        valueName: "text",
        label: ["name", "id"],
        values: 'hello layui'
    });

    // 多选
    selectPlus.render({
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
})