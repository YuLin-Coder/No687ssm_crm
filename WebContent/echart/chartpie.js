$(window).load(function() {
	var loc = $("input[name='basepath']").val();
	var url = loc + "chart/chartPie.action";
	$.ajax({
		type : "get",
		url : url,
		dataType : "json",
		success : function(json) {
			var name = json.names.replace("[", "").replace("]", "").split(",");
			var val = json.count.replace("[", "").replace("]", "").split(",");
			var strName = [];
			for (var i = 0; i < name.length; i++) {
				strName.push({
					"name" : name[i],
					"value" : val[i]
				});
			}
			var arrNum = [];
			for (var i = 0; i < val.length; i++) {
				arrNum.push({
					name:'支付方式',
		            type:'pie',
		            radius : '55%',
		            center: ['50%', '60%'],
		            data:strName
				});
			}
			var option = {
				title : {
					text : '交易记录分析',
					left : 'center'
				},
				tooltip : {
					trigger : 'item',
					formatter : "{a} <br/>{b} : {c} ({d}%)"
				},
				legend : {
					orient : 'vertical',
					left : 'left',
					data : name
				},
				toolbox : {
					show : true,
					feature : {
						mark : {
							show : true
						},
						dataView : {
							show : true,
							readOnly : false
						},
						magicType : {
							show : true,
							type : [ 'pie', 'funnel' ],
							option : {
								funnel : {
									x : '25%',
									width : '50%',
									funnelAlign : 'left',
									max : 1548
								}
							}
						},
						restore : {
							show : true
						}
					}
				},
				calculable : true,
				series : arrNum
			};
			// 初始化echarts实例
			var myChart = echarts.init(document.getElementById('chartmain'));

			// 使用制定的配置项和数据显示图表
			myChart.setOption(option);
		},
		error : function() {
			alert("ajax请求发生错误3");
		}
	});
});
