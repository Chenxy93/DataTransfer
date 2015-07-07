package XML2SAX;

public class Article {
	
	private String fileName;
	private String doi;
	private String journal;
	private String jcode;
	private String jshort;
	private String volume;
	private String issue;
	private String printdate;
	private String fpage;
	private String lpage;
	private String seqno;
	private String price;
	private String tocsec;
	private String arttype;
	private String type;
	private String title;
	private String[] givenname = new String[1000];
	private String[] middlename= new String[1000];
	private String[] surname= new String[1000];
	private String aff;
	private String received_date;
	private String copyright_date;
	private String copyright_holder;
	private int authornum;//作者个数
	
	public void setDoi(String doi){
		this.doi=doi;
	}
	public void setJournal(String journal){
		this.journal=journal;
	}
	public void setJcode(String jcode){
		this.jcode=jcode;
	}
	public void setJshort(String jshort){
		this.jshort=jshort;
	}
	public void setVolume(String volume){
		this.volume=volume;
	}
	public void setIssue(String issue){
		this.issue=issue;
	}
	public void setPrintdate(String printdate){
		this.printdate=printdate;
	}
	public void setFpage(String fpage){
		this.fpage=fpage;
	}
	public void setLpage(String lpage){
		this.lpage=lpage;
	}
	public void setSeqno(String seqno){
		this.seqno=seqno;
	}
	public void setPrice(String price){
		this.price=price;
	}
	public void setTocsec(String tocsec){
		this.tocsec=tocsec;
	}
	public void setArttype(String arttype){
		this.arttype=arttype;
	}
	public void setType(String type){
		this.type=type;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public void setGivenname(String givenname,int num){
		this.givenname[num]=givenname;
	}
	public void setMiddlename(String middlename,int num){
		this.middlename[num]=middlename;
	}
	public void setSurname(String surname,int num){
		this.surname[num]=surname;
	}
	public void setAff(String aff){
		this.aff=aff;
	}
	public void setReceived_date(String received_date){
		this.received_date=received_date;
	}
	public void setCopyright_date(String copyright_date){
		this.copyright_date=copyright_date;
	}
	public void setCopyright_holder(String copyright_holder){
		this.copyright_holder=copyright_holder;
	}
	public void setAuthornum(int authornum){
		this.authornum = authornum;
	}
	
	public String getDoi(){
		return this.doi;
	}
	public String getJournal(){
		return journal;
	}
	public String getJcode(){
		return jcode;
	}
	public String getJshort(){
		return jshort;
	}
	public String getVolume(){
		return volume;
	}
	public String getIssue(){
		return issue;
	}
	public String getPrintdate(){
		return printdate;
	}
	public String getFpage(){
		return fpage;
	}
	public String getLpage(){
		return lpage;
	}
	public String getSeqno(){
		return seqno;
	}
	public String getPrice(){
		return price;
	}
	public String getTocsec(){
		return tocsec;
	}
	public String getArttype(){
		return arttype;
	}
	public String getType(){
		return type;
	}
	public String getTitle(){
		return title;
	}
	public String getGivenname(int num){
		return this.givenname[num];
	}
	public String getMiddlename(int num){
		return this.middlename[num];
	}
	public String getSurname(int num){
		return this.surname[num];
	}
	public String getAff(){
		return aff;
	}
	public String getReceived_date(){
		return received_date;
	}
	public String getCopyright_date(){
		return copyright_date;
	}
	public String getCopyright_holder(){
		return copyright_holder;
	}
	public int getAuthornum(){
		return authornum;
	}
	
	

}
