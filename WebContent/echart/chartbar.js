$(window).load(
		function() {
			var loc = $("input[name='basepath']").val();
			var url = loc + "chart/chartBar.action";
			$.ajax({
				type : "post",
				url : url,
				dataType : "json",
				success : function(json) {
					var cate = json.cate.replace("[", "").replace("]", "")
							.split(",");
					var count = json.count.replace("[", "").replace("]", "")
							.split(",");
					var strName = [];
					var strCount = [];
					for (var i = 0; i < cate.length; i++) {
						strName.push({
							"value" : cate[i]
						});
					}
					for (var i = 0; i < count.length; i++) {
						strCount.push({
							"name" : cate[i],
							"value" : count[i]
						});
					}
					var option = {
						title : {
							text : '客户信息分析',
							left : 'center'
						},
						xAxis : {
							type : 'category',
							data : cate
						},
						yAxis : {
							type : 'value'
						},
						series : [ {
							data : strCount,
							type : 'bar'
						} ]
					};
					// 初始化echarts实例
					var myChart = echarts.init(document
							.getElementById('chartmain'));
					// 使用制定的配置项和数据显示图表
					myChart.setOption(option);
				},
				error : function() {
					alert("ajax请求发生错误3");
				}
			});
		});
