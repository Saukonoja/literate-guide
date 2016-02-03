<?php
class Webpage {
	private $heading;
	private $keywords;
	private $content;

	function __construct($title, $metakeys){
		$this->heading = $title;
		$this->keywords = $metakeys;
	}

	function __destruct(){
		$this->heading = null;
		$this->keywords = null;
	}

	function printHeadingElement(){
		echo "<title>this->heading</title>";
	}

	function printKeywordsElement(){
		echo "<meta name='keywords' content'keyword1, keyword2'>";
	}

	function setBodyElementContent($content){
			$this->content=$content;
	}

	public function showPage(){
		echo "<html>";
		$this->printHeadingElement();
		$this->printKeywordsElement();
		echo "</head><body>\n";
		echo $this->content;
		echo "<body>\n</html>\n";
	}

}
?>
