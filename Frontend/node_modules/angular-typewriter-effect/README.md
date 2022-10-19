# ngtypewriter
ngtypewriter is a simple reacangular component to add effect to strings like typing

# Usage
        app.module.ts
        import { AngularTypewriterEffectModule } from 'angular-typewriter-effect';
        imports: [
            BrowserModule,
            AngularTypewriterEffectModule //<- import
        ],


        app.component.ts
        export class AppComponent implements OnInit{
            title = 'angularTests';
            list = ['Angular Typewriter Effect', 'Hello World...']
            constructor() { }
            ngOnInit() {
            }
        }
        app.component.html
        <ngtypewriter [StringList]='list' [speed]='1000'></ngtypewriter>

### props
  - StringList - Array of list
  - speed - Speed in ms

### Tech

* [Angular]

### Installation
```sh
npm i angular-typewriter-effect
```

### Development

Want to contribute? Great!

Make a pull request

License
----

ISC

   [Angular]: <https://angular.io/>
