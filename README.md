# whatsaround
The minimum android version for this project is API level 15 (Ice crem sandwitch). It covers more 90% of the devices of the market. 
Also using this API level enable us to use most recent android libraries, ViewGroups and frameworks.

Design Pattern:
 <ol>
<li>MVVM (Model View ViewModel): MVVM is very similar to MVP. Basic difference is it does not contain any reference to the view objects directly. 
I used android data binding librares for ViewModel data binding. Advantage of this approach is, since ViewModel is completely separate from Acitivty or 
fragment, rotating screen or other reason to recreate the Lifecycle owner (i.e Activity or Fragment) does not effect ViewModel at all</li>
</ol>

<b>android libraries</b>
<ol>
<li>Android Architecture Components: Except Live Data and persistent database (Room) I used most of the features of this library</li> 
<li>Android Data Binding: Using Data binding significantly reduce boiler plate codes.</li>
<li> Lifecycle-aware components: Life cycle aware components really helps to avoid memory leaks. Like attaching listener calls can greatly improvide by 
observing and adjusting with life cycle of activity or fragment</li>
<li> ViewModels: ViewModel used for strore and retain UI related data. A ViewModel call a repository for actual data and retain the data througout 
activity's lifecycle</li>
<li>Android Support Library: Used for fragments and fragment manager support libraries</li> 
<li>Dagger2: Used for simplified access to shared instances, ease of configuration of complex dependency and obviously for easier unit testing</li>
</ol>

<b>3rd Party libraries</b>
  <ol>
  <li>RxJava2: RxJava used for to subscribe to data emition. As in android we cannot do time consuming work in main thread, RxJava used to do it in a worker
  thread and subscribe the result emitted one by one in the main thread</li>
<li>Retrofit: Retrofit used for asynchronous Api calls. It complies fully with RxJava</li>
<li>Picasso: Picasso used to resize and put the bitmap in imageView for improve performance of the recyclerview</li>
</ol>
  

