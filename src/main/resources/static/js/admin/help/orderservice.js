$(function () {
	var columns = [

			{ checkbox: true, align: 'center' },
			{ title: '订单编号', field: 'orderNumber', formatter: function(value, row){
				return "<a class='a-detail' onClick='vm.detail("+row.id+")'>"+value+"</a>";
			}},
			{ title: '用户', field: 'member.nickname'},
			{ title: '订单金额', field: 'totalAmount'},
			{ title: '订单类型', field: 'orderType', formatter: function(value, row){
				if(value == 1){
					return '商品订单';
				}else if(value == 2){
					return '快递代取';
				}else if(value == 3){
					return '快递代寄';
				}else if(value == 4){
					return '周边代买';
				}
			}},
			{ title: '订单状态', field: 'orderStatus', formatter: function(value, row){
				if(value == 0){
					return '<span class="label label-default">已取消</span>';
				}else if(value == 1){
					return '<span class="label label-primary">待付款</span>';
				}else if(value == 2){
					return '<span class="label label-success">待接单</span>';
				}else if(value == 3){
					return '<span class="label label-info">已接单</span>';
				}else if(value == 4){
					return '<span class="label label-warning">已完成</span>';
				}
			}},
			{ title: '创建时间', field: 'createTime'} 			
]

$("#table").bootstrapTable({
	        url: baseURL + 'order/list',
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
		order: {
			orderService: {}
		},
		q: {
			
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.order = {};
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
		detail: function(id){
			vm.showList = false;
			vm.title = "详情";
			vm.getInfo(id);
		},
		saveOrUpdate: function (event) {
			var url = vm.orderService.id == null ? "order/save" : "order/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.string(order),
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
				    url: baseURL + "order/delete",
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
			$.get(baseURL + "order/info/"+id, function(r){
                vm.order = r.order;
            });
		},
		reload: function (event) {
			vm.showList = true;
			$('#table').bootstrapTable('refreshOptions',  {pageNumber: 1});
		}
	}
});