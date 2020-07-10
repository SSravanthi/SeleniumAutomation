package Fusion;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MyPhonePanel  {
	WebDriver driver = null;
	
	
	public void mPlToPl(){
		
			this.driver = Fusionmain.driver;
			System.out.println("CallTransfer - BEGIN"); // From MPL to Parking Lot
		    //Traget: #avpContainer app-parking tr.th2-exceeded.th1-exceeded
            //source: .top-section tbody tr.th2-exceeded.th1-exceeded
            // Transfer calls 
			System.out.println("Transfer call from MPP to Parking Lot");
            JavascriptExecutor jsDnDpo0 = (JavascriptExecutor) driver;           
            String jsLibraryString = "!function(t){t.fn.simulateDragDrop=function(a){return this.each(function(){new t.simulateDragDrop(this,a)})},t.simulateDragDrop=function(t,a){this.options=a,this.simulateEvent(t,a)},t.extend(t.simulateDragDrop.prototype,{simulateEvent:function(a,e){var n=\"dragstart\",r=this.createEvent(n);this.dispatchEvent(a,n,r),n=\"drop\";var i=this.createEvent(n,{});i.dataTransfer=r.dataTransfer,this.dispatchEvent(t(e.dropTarget)[0],n,i),n=\"dragend\";var s=this.createEvent(n,{});s.dataTransfer=r.dataTransfer,this.dispatchEvent(a,n,s)},createEvent:function(t){var a=document.createEvent(\"CustomEvent\");return a.initCustomEvent(t,!0,!0,null),a.dataTransfer={data:{},setData:function(t,a){this.data[t]=a},getData:function(t){return this.data[t]}},a},dispatchEvent:function(t,a,e){t.dispatchEvent?t.dispatchEvent(e):t.fireEvent&&t.fireEvent(\"on\"+a,e)}})}(jQuery);";            
            jsDnDpo0.executeScript(
                         jsLibraryString
                         + "function dndPhoneList(fromParam, iParam) {setTimeout(function(){fromParam.simulateDragDrop({ dropTarget: '#avpContainer app-parking tr.th2-exceeded.th1-exceeded'});}, iParam*5000);}"
                         + " "
                         + "var hc = 0;"
                         + "var r = 0;"
                         + "var ac = 0;"
                         + "var counter = 0;"
                         + "$('.top-section tbody tr.nobottomborder').each(function(i, v){"
                         + "  if($(this).find('.call-hold-call').length > 0) {"
                         + "    if(hc < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    hc++;"
                         + "  }"
                         + "  else if($(this).find('.call-ringing').length > 0) {"
                         + "    if(r < 2) {"
                         + "      dndPhoneList($(this), counter);"      
                         + "      counter++;"
                         + "    }"
                         + "    r++;"
                         + "  }"
                         + "  else if($(this).find('.call-active').length > 0) {"
                         + "    if(ac < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    ac++;"
                         + "  }"
                         + "});"

                         + "$('.top-section tbody tr.th1-exceeded').each(function(i, v){"
                         + "  if($(this).find('.call-hold-call').length > 0) {"
                         + "    if(hc < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    hc++;"
                         + "  }"
                         + "  else if($(this).find('.call-ringing').length > 0) {"
                         + "    if(r < 2) {"
                         + "      dndPhoneList($(this), counter);"      
                         + "      counter++;"
                         + "    }"
                         + "    r++;"
                         + "  }"
                         + "  else if($(this).find('.call-active').length > 0) {"
                         + "    if(ac < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    ac++;"
                         + "  }"
                         + "});"

                         + "$('.top-section tbody tr.th2-exceeded.th1-exceeded').each(function(i, v){"
                         + "  if($(this).find('.call-hold-call').length > 0) {"
                         + "    if(hc < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    hc++;"
                         + "  }"
                         + "  else if($(this).find('.call-ringing').length > 0) {"
                          + "    if(r < 2) {"
                         + "      dndPhoneList($(this), counter);"      
                         + "      counter++;"
                         + "    }"
                         + "    r++;"
                         + "  }"
                         + "  else if($(this).find('.call-active').length > 0) {"
                         + "    if(ac < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    ac++;"
                         + "  }"
                         + "});"
                         );

           
			
		}
		public void mPlToCq(){
			this.driver = Fusionmain.driver;
			System.out.println("CallTransfer - BEGIN"); // From MPL to Call queues
		    //Traget: #avpContainer app-call-queues tbody tr.th2-exceeded.th1-exceeded
            //source: .top-section tbody tr.th2-exceeded.th1-exceeded
            // Transfer calls 
			System.out.println("Transfer call from MPP to Call Queues");
            JavascriptExecutor jsDnDCQ = (JavascriptExecutor) driver;            
            String jsCQLibraryString = "!function(t){t.fn.simulateDragDrop=function(a){return this.each(function(){new t.simulateDragDrop(this,a)})},t.simulateDragDrop=function(t,a){this.options=a,this.simulateEvent(t,a)},t.extend(t.simulateDragDrop.prototype,{simulateEvent:function(a,e){var n=\"dragstart\",r=this.createEvent(n);this.dispatchEvent(a,n,r),n=\"drop\";var i=this.createEvent(n,{});i.dataTransfer=r.dataTransfer,this.dispatchEvent(t(e.dropTarget)[0],n,i),n=\"dragend\";var s=this.createEvent(n,{});s.dataTransfer=r.dataTransfer,this.dispatchEvent(a,n,s)},createEvent:function(t){var a=document.createEvent(\"CustomEvent\");return a.initCustomEvent(t,!0,!0,null),a.dataTransfer={data:{},setData:function(t,a){this.data[t]=a},getData:function(t){return this.data[t]}},a},dispatchEvent:function(t,a,e){t.dispatchEvent?t.dispatchEvent(e):t.fireEvent&&t.fireEvent(\"on\"+a,e)}})}(jQuery);";            
            jsDnDCQ.executeScript(
                         jsCQLibraryString
                         + "function dndPhoneList(fromParam, iParam) {setTimeout(function(){fromParam.simulateDragDrop({ dropTarget: '#avpContainer app-call-queues tbody tr.th2-exceeded.th1-exceeded'});}, iParam*5000);}"
                         + " "
                         + "var hc = 0;"
                         + "var r = 0;"
                         + "var ac = 0;"
                         + "var counter = 0;"
                         + "$('.top-section tbody tr.nobottomborder').each(function(i, v){"
                         + "  if($(this).find('.call-hold-call').length > 0) {"
                         + "    if(hc < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    hc++;"
                         + "  }"
                         + "  else if($(this).find('.call-ringing').length > 0) {"
                         + "    if(r < 2) {"
                         + "      dndPhoneList($(this), counter);"      
                         + "      counter++;"
                         + "    }"
                         + "    r++;"
                         + "  }"
                         + "  else if($(this).find('.call-active').length > 0) {"
                         + "    if(ac < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    ac++;"
                         + "  }"
                         + "});"

                         + "$('.top-section tbody tr.th1-exceeded').each(function(i, v){"
                         + "  if($(this).find('.call-hold-call').length > 0) {"
                         + "    if(hc < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    hc++;"
                         + "  }"
                         + "  else if($(this).find('.call-ringing').length > 0) {"
                         + "    if(r < 2) {"
                         + "      dndPhoneList($(this), counter);"      
                         + "      counter++;"
                         + "    }"
                         + "    r++;"
                         + "  }"
                         + "  else if($(this).find('.call-active').length > 0) {"
                         + "    if(ac < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    ac++;"
                         + "  }"
                         + "});"

                         + "$('.top-section tbody tr.th2-exceeded.th1-exceeded').each(function(i, v){"
                         + "  if($(this).find('.call-hold-call').length > 0) {"
                         + "    if(hc < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    hc++;"
                         + "  }"
                         + "  else if($(this).find('.call-ringing').length > 0) {"
                         + "    if(r < 2) {"
                         + "      dndPhoneList($(this), counter);"      
                         + "      counter++;"
                         + "    }"
                         + "    r++;"
                         + "  }"
                         + "  else if($(this).find('.call-active').length > 0) {"
                         + "    if(ac < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    ac++;"
                         + "  }"
                         + "});"
                         );

            System.out.println("Transfer call from MPP to Call Queues");
		
		}
		public void mplToPg(){
			this.driver = Fusionmain.driver;
			System.out.println("CallTransfer - BEGIN"); //MPL To Phone Group
			//Traget: #avpContainer app-phone-group tbody tr.nobottomborder
            //source: .top-section tbody tr.th2-exceeded.th1-exceeded
            // Transfer calls 
			System.out.println("Transfer call from MPP to Phone groups ");
            JavascriptExecutor jsDnDPG = (JavascriptExecutor) driver;            
            String jsPGLibraryString = "!function(t){t.fn.simulateDragDrop=function(a){return this.each(function(){new t.simulateDragDrop(this,a)})},t.simulateDragDrop=function(t,a){this.options=a,this.simulateEvent(t,a)},t.extend(t.simulateDragDrop.prototype,{simulateEvent:function(a,e){var n=\"dragstart\",r=this.createEvent(n);this.dispatchEvent(a,n,r),n=\"drop\";var i=this.createEvent(n,{});i.dataTransfer=r.dataTransfer,this.dispatchEvent(t(e.dropTarget)[0],n,i),n=\"dragend\";var s=this.createEvent(n,{});s.dataTransfer=r.dataTransfer,this.dispatchEvent(a,n,s)},createEvent:function(t){var a=document.createEvent(\"CustomEvent\");return a.initCustomEvent(t,!0,!0,null),a.dataTransfer={data:{},setData:function(t,a){this.data[t]=a},getData:function(t){return this.data[t]}},a},dispatchEvent:function(t,a,e){t.dispatchEvent?t.dispatchEvent(e):t.fireEvent&&t.fireEvent(\"on\"+a,e)}})}(jQuery);";            
            jsDnDPG.executeScript(
                         jsPGLibraryString
                         + "function dndPhoneList(fromParam, iParam) {setTimeout(function(){fromParam.simulateDragDrop({ dropTarget: '#avpContainer app-phone-group tbody tr.nobottomborder'});}, iParam*5000);}"
                         + " "
                         + "var hc = 0;"
                         + "var r = 0;"
                         + "var ac = 0;"
                         + "var counter = 0;"
                         + "$('.top-section tbody tr.nobottomborder').each(function(i, v){"
                         + "  if($(this).find('.call-hold-call').length > 0) {"
                         + "    if(hc < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    hc++;"
                         + "  }"
                         + "  else if($(this).find('.call-ringing').length > 0) {"
                         + "    if(r < 2) {"
                         + "      dndPhoneList($(this), counter);"      
                         + "      counter++;"
                         + "    }"
                         + "    r++;"
                         + "  }"
                         + "  else if($(this).find('.call-active').length > 0) {"
                         + "    if(ac < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    ac++;"
                         + "  }"
                         + "});"

                         + "$('.top-section tbody tr.th1-exceeded').each(function(i, v){"
                         + "  if($(this).find('.call-hold-call').length > 0) {"
                         + "    if(hc < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    hc++;"
                         + "  }"
                         + "  else if($(this).find('.call-ringing').length > 0) {"
                         + "    if(r < 2) {"
                         + "      dndPhoneList($(this), counter);"      
                         + "      counter++;"
                         + "    }"
                         + "    r++;"
                         + "  }"
                         + "  else if($(this).find('.call-active').length > 0) {"
                         + "    if(ac < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    ac++;"
                         + "  }"
                         + "});"

                         + "$('.top-section tbody tr.th2-exceeded.th1-exceeded').each(function(i, v){"
                         + "  if($(this).find('.call-hold-call').length > 0) {"
                         + "    if(hc < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    hc++;"
                         + "  }"
                         + "  else if($(this).find('.call-ringing').length > 0) {"
                         + "    if(r < 2) {"
                         + "      dndPhoneList($(this), counter);"      
                         + "      counter++;"
                         + "    }"
                         + "    r++;"
                         + "  }"
                         + "  else if($(this).find('.call-active').length > 0) {"
                         + "    if(ac < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    ac++;"
                         + "  }"
                         + "});"
                         );

            System.out.println("Transfer call from MPP to Phone groups");
		}
		public void mplToPo(){
			this.driver = Fusionmain.driver;
			System.out.println("CallTransfer - BEGIN"); //MPL To Phone Group
			//Traget: #avpContainer app-phone tbody tr.nobottomborder
            //source: .top-section tbody tr.th2-exceeded.th1-exceeded
            // Transfer calls 
			System.out.println("Transfer call from MPP to Phone Object ");
            JavascriptExecutor jsDnDPG = (JavascriptExecutor) driver;            
            String jsPGLibraryString = "!function(t){t.fn.simulateDragDrop=function(a){return this.each(function(){new t.simulateDragDrop(this,a)})},t.simulateDragDrop=function(t,a){this.options=a,this.simulateEvent(t,a)},t.extend(t.simulateDragDrop.prototype,{simulateEvent:function(a,e){var n=\"dragstart\",r=this.createEvent(n);this.dispatchEvent(a,n,r),n=\"drop\";var i=this.createEvent(n,{});i.dataTransfer=r.dataTransfer,this.dispatchEvent(t(e.dropTarget)[0],n,i),n=\"dragend\";var s=this.createEvent(n,{});s.dataTransfer=r.dataTransfer,this.dispatchEvent(a,n,s)},createEvent:function(t){var a=document.createEvent(\"CustomEvent\");return a.initCustomEvent(t,!0,!0,null),a.dataTransfer={data:{},setData:function(t,a){this.data[t]=a},getData:function(t){return this.data[t]}},a},dispatchEvent:function(t,a,e){t.dispatchEvent?t.dispatchEvent(e):t.fireEvent&&t.fireEvent(\"on\"+a,e)}})}(jQuery);";            
            jsDnDPG.executeScript(
                         jsPGLibraryString
                         + "function dndPhoneList(fromParam, iParam) {setTimeout(function(){fromParam.simulateDragDrop({ dropTarget: '#avpContainer app-phone #phone-component-CorporatePhoneUjY3QfYjbienZhJWEV72hk tbody tr.nobottomborder'});}, iParam*5000);}"
                         + " "
                         + "var hc = 0;"
                         + "var r = 0;"
                         + "var ac = 0;"
                         + "var counter = 0;"
                         + "$('.top-section tbody tr.nobottomborder').each(function(i, v){"
                         + "  if($(this).find('.call-hold-call').length > 0) {"
                         + "    if(hc < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    hc++;"
                         + "  }"
                         + "  else if($(this).find('.call-ringing').length > 0) {"
                         + "    if(r < 2) {"
                         + "      dndPhoneList($(this), counter);"      
                         + "      counter++;"
                         + "    }"
                         + "    r++;"
                         + "  }"
                         + "  else if($(this).find('.call-active').length > 0) {"
                         + "    if(ac < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    ac++;"
                         + "  }"
                         + "});"

                         + "$('.top-section tbody tr.th1-exceeded').each(function(i, v){"
                         + "  if($(this).find('.call-hold-call').length > 0) {"
                         + "    if(hc < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    hc++;"
                         + "  }"
                         + "  else if($(this).find('.call-ringing').length > 0) {"
                         + "    if(r < 2) {"
                         + "      dndPhoneList($(this), counter);"      
                         + "      counter++;"
                         + "    }"
                         + "    r++;"
                         + "  }"
                         + "  else if($(this).find('.call-active').length > 0) {"
                         + "    if(ac < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    ac++;"
                         + "  }"
                         + "});"

                         + "$('.top-section tbody tr.th2-exceeded.th1-exceeded').each(function(i, v){"
                         + "  if($(this).find('.call-hold-call').length > 0) {"
                         + "    if(hc < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    hc++;"
                         + "  }"
                         + "  else if($(this).find('.call-ringing').length > 0) {"
                         + "    if(r < 2) {"
                         + "      dndPhoneList($(this), counter);"      
                         + "      counter++;"
                         + "    }"
                         + "    r++;"
                         + "  }"
                         + "  else if($(this).find('.call-active').length > 0) {"
                         + "    if(ac < 2) {"
                         + "      dndPhoneList($(this), counter);"
                         + "      counter++;"
                         + "    }"
                         + "    ac++;"
                         + "  }"
                         + "});"
                         );

            System.out.println("Transfer call from MPP to Phone Object");
		}
    
}
