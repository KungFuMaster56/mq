/**
 * 表格
 * @returns
 */
function table(){
	this.toolbar = [{
	            text:'增加',
	            iconCls:'icon-add',
	            handler:function(){addRow()}
	        },{
	            text:'删除',
	            iconCls:'icon-remove',
	            handler:function(){delRow()}
	        },{
	            text:'修改',
	            iconCls:'icon-edit',
	            handler:function(){editRow()}
	        },'-',{
	            text:'保存',
	            iconCls:'icon-save',
	            handler:function(){save()}
	        },'-',{
	            text:'查询',
	            iconCls:'icon-search',
	            handler:function(){search()}
	        },'-',{
	            text:'全部开启',
	            iconCls:'icon-ok',
	            handler:function(){
	            	var data = $('#tt').datagrid('getRows');
	            	for(var i =0;i<data.length;i++){
	            		var row = data[i];
	            		if(row['onoff']!='ON'){
	            			openMessage(row);
	            		}
	            	}
	            	
	            }
	        },'-',{
	            text:'全部立即执行',
	            iconCls:'icon-ok',
	            handler:function(){
	            	var data = $('#tt').datagrid('getRows');
	            	for(var i =0;i<data.length;i++){
	            		var row = data[i];
	            		if(row['onoff']!='ON'){
	            			row['immediately']=true;
	            			openMessage(row);
	            		}
	            	}
	            }
	        },'-',{
	            text:'全部关闭',
	            iconCls:'icon-no',
	            handler:function(){
	            	var data = $('#tt').datagrid('getRows');
	            	for(var i =0;i<data.length;i++){
	            		var row = data[i];
	            		if(row['onoff']!='OFF'){
	            			closeMessage(row);
	            		}
	            	}
	            }
	        }];
	this.subtoolbar = [{
        text:'增加',
        iconCls:'icon-add',
        handler:function(){addRow()}
    },{
        text:'删除',
        iconCls:'icon-remove',
        handler:function(){delRow()}
    },{
        text:'修改',
        iconCls:'icon-edit',
        handler:function(){editRow()}
    },'-',{
        text:'保存',
        iconCls:'icon-save',
        handler:function(){save()}
    },'-',{
        text:'查询',
        iconCls:'icon-search',
        handler:function(){search()}
    }];
	 var editIndex = undefined;
	 function endEditing(){
         if (editIndex == undefined){return true}
         if ($('#tt').datagrid('validateRow', editIndex)){
             $('#tt').datagrid('endEdit', editIndex);
             editIndex = undefined;
             return true;
         } else {
             return false;
         }
     }
	var search = function(){
		$('#tt').datagrid('reload');
	}
	var disableHandleButton = function(editIndex){
		$('input[data-num="'+editIndex+'"]').switchbutton({
     		checked:false,
     		readonly:true
     	});
         $('a[data-num="'+editIndex+'"]').linkbutton({
				disabled:true });
	}
	var addRow = function(){
		 if (endEditing()){
             $('#tt').datagrid('appendRow',{});
             editIndex = $('#tt').datagrid('getRows').length-1;
             $('#tt').datagrid('selectRow', editIndex)
                     .datagrid('beginEdit', editIndex);
             disableHandleButton(editIndex);
         }
	}
	var delRow = function(){
		editIndex=$('#tt').datagrid('getRowIndex',$('#tt').datagrid('getSelected'));
		if(editIndex == undefined || editIndex == -1){return}
        $('#tt').datagrid('cancelEdit', editIndex)
                .datagrid('deleteRow', editIndex);
        editIndex = undefined;
	}
	var editRow = function(){
		if (endEditing()){
			editIndex=$('#tt').datagrid('getRowIndex',$('#tt').datagrid('getSelected'));
			$('#tt').datagrid('beginEdit', editIndex);
		}
		 disableHandleButton(editIndex);
	}
	var save = function(){
		var gridUrl = $('#tt').datagrid('options')['url'];
		if (endEditing()){
			var ins = $('#tt').datagrid('getChanges','inserted');
			var del = $('#tt').datagrid('getChanges','deleted');
			var upd = $('#tt').datagrid('getChanges','updated');
			var data,t;
			if(ins.length!=0){
				fire(ins,'post',gridUrl);
			}
			if(upd.length!=0){
				fire(upd,'put',gridUrl);
			}
			if(del.length!=0){
				fire(del,'delete',gridUrl);
			}
		}
	}
	var fire = function(data,type,url){
		$.ajax({
			url:url,//'task',
			type:type,//'post'
			data:JSON.stringify(data),
			contentType:'application/json;charset=utf-8',
			//dataType:'json',
			success:function(data){
					// $.messager.alert('信息','执行成功!','info');
					 search();
			},
			error:function(data){
				alert("ERRO   "+JSON.stringify(data))
			}
		})
	}
	this.switchButton = function(value,row,index){
		return ' <input data-num="'+index+'" name ="switchButton" switch="'+value+'"/><a data-num="'+index+'" href="#">立即执行</a>';
	}
	this.loadSuccess = function(data){
		var data = $('#tt').datagrid('getRows');
		var check = false;
		for(var i =0;i<data.length;i++){
			if(data[i]['onoff']=='ON'){
				check = true;
			}else{
				check =false;
			}
			$('input[data-num="'+i+'"]').switchbutton({
	    		checked:check,
	    		onChange: function(checked){
	    			var index = $(this).attr('data-num');
	    			var row = data[index];
	             // alert(JSON.stringify($(this).switchbutton('options')))
	    			if(checked){
	    				openMessage(row);
	    			}else{
	    				closeMessage(row);
	    			}
	            }	
			});
			$('a[data-num="'+i+'"]').linkbutton({
				disabled:check ,
				onClick:function(){
					var index = $(this).attr('data-num');
	    			var row = data[index];
	    			row['immediately']=true;
	    			openMessage(row);
				}
			});
		}
	}
	var openMessage = function(row){
		//alert('open message!!'+JSON.stringify(row))
		row['onoff']='ON';
		fire(row,'post','message/scheduler');
	}
	var closeMessage = function(row){
		//alert('close message!!'+JSON.stringify(row));
		row['onoff']='OFF';
		fire(row,'delete','message/scheduler');
	}
	
	this.communicationData = [{'communication':'QUEUE','communication_name':'队列'},{'communication':'TOPIC','communication_name':'订阅'}];
	this.enableFilter = function(){
		 $('#tt').datagrid('enableFilter',[{
			 field:'onoff',
			 type:'combobox',
			 options:{
				 editable:false,
				 panelHeight:'auto',
                 data:[{value:'',text:'所有状态'}],
                 onChange:function(value){
                     if (value == ''){
                    	 $('#tt').datagrid('removeFilterRule', 'onoff');
                     } /*else {
                    	 $('#tt').datagrid('addFilterRule', {
                             field: 'onoff',
                             op: 'equal',
                             value: value
                         });
                     }*/
                     $('#tt').datagrid('doFilter');
                 }
			 }
		 }]);
	}
}

	var table = new table();
	$(function(){
		table.enableFilter();
	})

	
	//var tbar = t.toolbar;
