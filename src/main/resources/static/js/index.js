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
	var addRow = function(){
		 if (endEditing()){
             $('#tt').datagrid('appendRow',{});
             editIndex = $('#tt').datagrid('getRows').length-1;
             $('#tt').datagrid('selectRow', editIndex)
                     .datagrid('beginEdit', editIndex);
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
	}
	var save = function(){
		if (endEditing()){
			var rows = $('#tt').datagrid('getChanges');
			alert(rows.length+' rows are changed!');
		}
	}
}

	var table = new table();
	//var tbar = t.toolbar;
