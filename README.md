# SimpleNusicApp
Contains two screens Albums and Album details</br>
on click on album from Albums screen it redirects you to it's details</br>

Used kotlin coroutines, jetpack compose, realm and retrofit.</br>
Used MVI with clean architecture and Domain Driven Design</br>
Used Modules: Split project into app, feature, core:network , core:database and utils </br>
Used Hilt to achieve Dependency injection</br>

Why DDD? to be able to use same domain layer with any kotlin project in future (like KMM) so it's pure kotlin whithout any depedncy on platform</br>
Why coroutines? because it's pure kotlin, light weight and better in performance </br>
Why Modules? </br>
make each feature lib module to be apple to run it independent to be more faster while build, single point of failure and easy to assign owner for it.</br>
make database module contains all Doa to have single module to change if we decide to replace room by anything else.</br>
make utils module to be reusable.
Simply moduralization makes the components scalable and reusable.

Clone project using android studio on master branch.</br>
Screenshots:</br>
![alt text](/details.jpeg?raw=true)
![alt text](/home.jpeg?raw=true)



