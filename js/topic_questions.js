var btn = document.getElementById('btn');
var tp_id = document.getElementById('tp_id');
var tp_nm = document.getElementById('tp_nm');

btn.onclick = function(){
				window.location = 'show_post_question.do?topic_id='+tp_id.value+'&topic='+tp_nm.value;
			  };