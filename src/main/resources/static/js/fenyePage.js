var pagination = {
    code: '',

    // converting initialize data
    extend: function (data) {
        console.log('进入extend()');
        data = data || {};
        pagination.size = data.size || 300;
        pagination.page = data.page || 1;
        pagination.step = data.step || 3;
        console.log('赋值size=', pagination.size, 'page=', pagination.page, 'step=', pagination.step);
    },

    // add pages by number (from [s] to [f])
    add: function (s, f) {
        console.log('进入add()', 's=', s, 'f=', f);
        for (var i = s; i < f; i++) {
            pagination.code += '<a>' + i + '</a>';
        }
        console.log(JSON.stringify(pagination.code));
    },


    // add last page with separator[分隔符]
    last: function () {
        console.log('进入last()', 'size=', pagination.size);
        pagination.code += '<i>...</i><a>' + pagination.size + '</a>';
        console.log(JSON.stringify(pagination.code));
    },

    first: function () {
        console.log('进入first()');
        pagination.code += '<a>1</a><i>...</i>';
    },

    Click: function () {
        console.log('进入click()');
        alert(this.innerHTML);
        pagination.page = +this.innerHTML;
        alert(pagination.page);
        console.log(JSON.stringify(pagination.page));
        pagination.start();
    },

    //previous page
    prev: function () {
        console.log('进入prev()');
        pagination.page--;
        if (pagination.page < 1) {
            pagination.page = 1;
        }
        pagination.start();
    },

    //next page
    next: function () {
        console.log('进入next()');
        pagination.page++;
        if (pagination.page > pagination.size) {
            pagination.page = pagination.size;
        }
        pagination.start();
    },

    //binding pages
    bind: function () {
        console.log('进入bind','e=',JSON.stringify(pagination.e));
        var a = pagination.e.getElementsByTagName('a');
        for (var i = 0; i < a.length; i++) {
            if (+a[i].innerHTML === pagination.page) a[i].className = 'current';
            a[i].addEventListener('click', pagination.Click, false);
        }
    },

    // write pagination
    finish: function () {
        console.log('进入finish()');
        pagination.e.innerHTML = pagination.code;
        pagination.code = '';
        pagination.bind();
        console.log('进入back()');
        console.log(pagination.page);
        back(pagination.page);
    },

    // find pagination type
    start: function () {
        console.log('进入start()', 'page=',pagination.page,'size=', pagination.size, 'step=', pagination.step);
        if (pagination.size < pagination.step * 2 + 6) {
            console.log('pagination.size<pagination.step*2+6');
            pagination.add(1, pagination.size + 1);
        }
        else if (pagination.page < pagination.step * 2 + 1) {
            console.log('pagination.page<pagination.step*2+1');
            pagination.add(1, pagination.step * 2 + 4);
            pagination.last();
        }
        else if (pagination.page > pagination.size - pagination.step * 2) {
            console.log('pagination.page>pagination.size - pagination.step*2');
            pagination.first();
            pagination.add(pagination.size - pagination.step * 2 - 2, pagination.size + 1);
        }
        else {
            console.log('else');
            pagination.first();
            pagination.add(pagination.page - pagination.step, pagination.page + pagination.step + 1);
            pagination.last();
        }
        pagination.finish();
    },

    buttons: function (e) {
        console.log('进入buttons()','e=',JSON.stringify(e));
        var nav = e.getElementsByTagName('a');
        console.log('nav=', JSON.stringify(nav));
        nav[0].addEventListener('click', pagination.prev, false);
        nav[1].addEventListener('click', pagination.next, false);

    },

    // create skeleton
    create: function (e) {
        console.log('进入create()');
        var html;
        if (pagination.page != 1 && pagination.page != pagination.size)
            html = [
                '<a>&#9668;</a>',   // previous button
                '<span></span>',    // pagination container
                '<a>&#9658;</a>'    // next button
            ];
        else if (pagination.page == 1)
            html = [
                '<a style="display: none">&#9668;</a>',
                '<span></span>',
                '<a>&#9658;</a>'
            ];
        else{
            html = [
                '<a>&#9668;</a>',
                '<span></span>',
                '<a style="display: none">&#9658;</a>'
            ];
        }
        console.log(JSON.stringify(html));
        e.innerHTML = html.join('');
        pagination.e = e.getElementsByTagName('span')[0];
        pagination.buttons(e);
    },

    // init
    init: function (e, data) {
        console.log('进入init()');
        pagination.extend(data);
        pagination.create(e);
        pagination.start();

    }
};
