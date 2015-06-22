jQuery(document).ready(function(){ 
  jQuery("#grid").jqGrid({
    url:'/persons.jqgrid.json',
    datatype: 'json',
    colNames: ['ID','Name', 'Age', 'Country'],
    colModel: [ 
      {name:'id', index:'id', width:255, key:true, frozen: true}, 
      {name:'name', index:'name', width:220, editable: true, edittype: 'text', editoptions: {}}, 
      {name:'age', index:'age', width:280, editable: true, edittype: 'text'}, 
      {name:'country', index:'country', width:200, editable: true, edittype: 'select', editoptions: {value: 'Japan:Japan;US:US'}}
    ],
    shrinkToFit: false,
    onSelectRow: editRow,
    pager: '#pgrid',
    height: "100%",
    width: 800,
    regional: 'ja'
  });
  jQuery('#grid').jqGrid('filterToolbar');
  jQuery("#grid").jqGrid('navGrid','#pgrid',{edit:false,add:false,del:false,search:false});
  jQuery("#grid").jqGrid("setFrozenColumns");

  var lastSelection;
  function editRow(id) {
    console.log('id = ' + id);
    if (id && id !== lastSelection) {
      var grid = jQuery('#grid');
      grid.jqGrid('restoreRow', lastSelection);
      grid.jqGrid('editRow', id, {keys:true, focusField: 4});
      lastSelection = id;
    }
  }
});