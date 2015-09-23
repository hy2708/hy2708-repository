我把观察者模式,理解为响应者模式,订阅模式

subject=event         只有一个事件，或者主题只有一个可以被改变的状态的时候
subject=event+source  有多个事件，或者主题多个可以被改变的状态的时候。例如在UI里面的鼠标单击，拖动

observer=listener=handler