const LEFT_BANNER_LIST = [
    {
        laber: "员工管理",
        link: ""
    },
    {
        laber: "分类管理",
        link: ""
    },
    {
        laber: "菜品管理",
        link: ""
    },
    {
        laber: "套餐管理",
        link: ""
    },
    {
        laber: "订单管理",
        link: ""
    }
];

window.onload = function () {
    initLeftBanner()
    initContentPage()
    initAddEmployeePage()
    initMain()

}

function initLeftBanner() {
    //********左边菜单逻辑start********** */
    var listDome = document.querySelector("#backend .left-banner .list")
    var strList = ``
    for (var i = 0; i < LEFT_BANNER_LIST.length; i++) {
        var item = LEFT_BANNER_LIST[i]
        var itemstr = `<div class="label-item" data-link=${item.link}>${item.laber}</div>`
        strList += itemstr
    }
    listDome.innerHTML = strList
    listDome.addEventListener('click', function (e) {
        console.log(e.target)
        var _target = e.target
        var others = e.currentTarget.querySelectorAll(".label-item")
        for (var i = 0; i < others.length; i++) {
            others[i].className = "label-item"
        }
        _target.className = "label-item active"
    })
    //********左边菜单逻辑end********** */
}

function initContentPage() {
    //********点击添加员工按钮start********** */
    document.getElementById('addEmployee').addEventListener('click', function () {
        document.querySelector('.employee-wrap').className = 'employee-wrap hidden'
        document.querySelector('.addEmploy-wrap').className = 'addEmploy-wrap'
    });
   

}

function initAddEmployeePage() {
    //********点击添加员工start********** */
    document.getElementById('saveEmployee').addEventListener('click', function () {
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", "http://localhost:8080/employee/addOrEudate", true);
        xhttp.setRequestHeader('Content-Type', 'application/json')
        xhttp.send("");
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                var res = JSON.parse(this.responseText)
                if (res.code == '1') {
                    localStorage.removeItem("employee")
                    location.href = '/pages/page/login.html'
                }
            }
        };
    });

    document.querySelector('.goHome').addEventListener('click', function () {
        document.querySelector('.employee-wrap').className = 'employee-wrap'
        document.querySelector('.addEmploy-wrap').className = 'addEmploy-wrap hidden'
    });

    document.querySelector('.save').addEventListener('click', function () {
        var form = document.getElementById('addForm')
        var username = form.querySelector('input[name="username"]').value
        var name = form.querySelector('input[name="name"]').value
        var phone = form.querySelector('input[name="phone"]').value
        var sex = form.querySelector('input[name="sex"]:checked').value
        var id_number = form.querySelector('input[name="id_number"]').value
        var obj = {
            username : username,
            name : name,
            phone: phone,
            sex:sex,
            idNumber: id_number
        }
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", "http://localhost:8080/employee/addOrEudate", true);
        xhttp.setRequestHeader('Content-Type', 'application/json')
        xhttp.send(JSON.stringify(obj));
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                var res = JSON.parse(this.responseText)
                if (res.code == '1') {
                   
                }
            }
        };
        document.querySelector('.employee-wrap').className = 'employee-wrap'
        document.querySelector('.addEmploy-wrap').className = 'addEmploy-wrap hidden'
    });
    //********点击添加员工end********** */
}
function initMain() {
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/employee/selectPage?page=1&pageSize=8", true);
    xhttp.setRequestHeader('Content-Type', 'application/json')
    xhttp.send();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var res = JSON.parse(this.responseText)
            console.log(res)
            if (res.code == '1'&&res.data.records) {
                var content_list = document.querySelector(".content-list")
                var _strs = ''
                for(var i=0;i<res.data.records.length;i++){
                    var item = res.data.records[i]
                    var itemStr = `<div class="content-header">
                                        <div class="header-item">${item.name}</div>
                                        <div class="header-item">${item.username}</div>
                                        <div class="header-item">${item.phone}</div>
                                        <div class="header-item">${item.status}</div>
                                        <div class="header-item">${item.username}</div>
                                    </div>`
                    _strs +=itemStr
                }
                console.log(_strs)
                content_list.innerHTML = _strs
            }
        }
    };
}