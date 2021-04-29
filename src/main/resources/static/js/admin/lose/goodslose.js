$(function () {
	var columns = [

			{ checkbox: true, align: 'center' },
			{ title: '图片', field: 'picUrl',
				formatter: function (value, row, index) {
					return '<img width="100px" src="'+value+'" />';
			} }, 			
			{ title: '物品名称', field: 'goodsName' }, 			
			{ title: '地址', field: 'address' }, 			
			{ title: '姓名', field: 'realName' }, 			
			{ title: '手机号', field: 'mobile' }, 			
			{ title: '类型', field: 'type', formatter: function(value, row){
				if(value == 1){
					return '<span class="label label-primary">丢失</span>';
				}else{
					return '<span class="label label-danger">捡到</span>';
				}
			} }, 			
			{ title: '提交时间', field: 'createTime' }			
]

$("#table").bootstrapTable({
	        url: baseURL + 'goodslose/list',
	        cache: false,
	        striped: true,
	        pagination: true,
	        pageSize: 10,
	        pageNumber: 1,
	        sidePagination: 'server',
	        pageList: [10, 25, 50],
	        columns: columns,
	        queryParams: function (params) {
	        	return {
		        	page: params.offset / 10 + 1,
		        	limit: params.limit
	        	}
	        }
	   });
});
var vm = new Vue({
	el:'#app',
	data:{
		showList: true,
		title: null,
		goodsLose: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.goodsLose = {};
		},
		update: function (event) {
			var id = getSelectedVal("id");
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.goodsLose.id == null ? "goodslose/save" : "goodslose/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.goodsLose),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedVals("id");
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "goodslose/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "goodslose/info/"+id, function(r){
                vm.goodsLose = r.goodsLose;
            });
		},
		reload: function (event) {
			vm.showList = true;
			$('#table').bootstrapTable('refreshOptions',  {pageNumber: 1});
		}
	}
});