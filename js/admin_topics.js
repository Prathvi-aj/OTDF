//##########################Collect Topics#######################
window.onload = collectTopics;

var topiclist = document.getElementById('topic_list');

var tpReq = null;
function collectTopics(){
	tpReq = new XMLHttpRequest();

	tpReq.open('get','collect_topics.do',true);
	tpReq.onreadystatechange = showTopics;
	tpReq.send(null);
}

function showTopics(){
	if(tpReq.readyState==4&&tpReq.status==200){
		var result = eval(tpReq.responseText);
		
		topiclist.innerHTML = '';

		for(i=0;i<result.length;i++){
			var dv = document.createElement('div');
			dv.className = 'topic_records';
			dv.innerHTML = result[i].topic;

			topiclist.appendChild(dv);
		}
	}
}



//##########################New Topic#######################
var topic_fld = document.getElementById('topic_fld');
var topic_sbm = document.getElementById('topic_sbm');

topic_sbm.onclick = saveTopic;

var svTpReq = null;
function saveTopic(){
	svTpReq = new XMLHttpRequest();

	svTpReq.open('get','new_topic.do?topic='+topic_fld.value,true);
	svTpReq.onreadystatechange = afterSaveTopic;
	svTpReq.send(null);
}

function afterSaveTopic(){
	if(svTpReq.readyState==4&&svTpReq.status==200){
		var res = svTpReq.responseText;

		if(res=='success'){
			collectTopics();
			topic_fld.value = '';
		}		
	}
}