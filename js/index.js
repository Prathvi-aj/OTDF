window.onload = initAll;

function initAll(){
	getAllElements();
	collectTopics();
}

var topic_box;
function getAllElements(){
	topic_box = document.getElementById('topic_box');
}


var tpReq = null;
function collectTopics(){
	tpReq = new XMLHttpRequest();

	tpReq.open('get','admin/collect_topics.do',true);
	tpReq.onreadystatechange = showTopics;
	tpReq.send(null);
}

function showTopics(){
	if(tpReq.readyState==4&&tpReq.status==200){
		var records = eval(tpReq.responseText);

		for(i=0;i<records.length;i++){
			var row = topic_box.insertRow(i+1);

			var c1 = row.insertCell(0);
			c1.innerHTML = records[i].topicId;
			
			var c2 = row.insertCell(1);
			c2.innerHTML = '<a href="topic_questions.do?topic_id='+records[i].topicId+'&topic='+records[i].topic+'">'+records[i].topic+'</a>';

			var c3 = row.insertCell(2);
			c3.style.textAlign = 'center';
			c3.innerHTML = records[i].questionCount;

			var c4 = row.insertCell(3);
			c4.style.textAlign = 'center';
			c4.innerHTML = records[i].openQuestion;

			var c5 = row.insertCell(4);
			c5.innerHTML = records[i].lastUpdate;
		}
	}
}