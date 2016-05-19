# cider-diet
(because it is supposed to be lightweight)

## Disclaimer

Warning: bad code below!  
This is just a proof-of-concept (I spent just 1 hour making this)!  
Use at your own risk.  
Also, I don't know about `nrepl`/`cider`/`clojure`/whatever internals much.  

## Why

See https://github.com/clojure-emacs/cider/issues/1717

**Timings:**

| command | time | description |
|-------------|---------|---------|
| `java -jar Test` | 0.1s | JVM startup time is blazing fast. Simple Hello World app starts almost instantly: |
| `java -jar clojure-1.8.0.jar` | 1-1.3s | Clojure REPL is much slower, but still pretty fast: |
| `java -cp $MY_CIDER_NREPL_CP clojure.main` | 1-1.3s | Clojure REPL with cider-nrepl's CLASSPATH |
|  `lein repl` (+ `nrepl`) | 11s | Slow: Ten times slower! |
| `lein repl` (+ `nrepl`) + `cider-nrepl` | 20-24s | SLOWER |
| `cider-jack-in` | 30-32s | Unbearably SLOW |

## What

The idea is to get working nREPL session for `cider` fast.  
I don't know why we need `lein`/`boot`/`gradle` for that.  
For example, `lein repl` does a lot of stuff under the hood (not just `java -jar clojure-1.X.Y.jar`), that is why it takes so long to start.  

In 99% of cases when I want to write Clojure code (not often these days) all I need is a working Clojure REPL + frontend (emacs) for it.  
What I don't want in 100% of cases is to wait 30s before it starts.  

At first I wanted to profile `lein repl` to figure out why it was slow.  
But profiling snapshot's size was 851MB and it was boring.  
I couldn't find any particular reason why it was so slow.  

So I decided to do this.  

## How

1. Checkout this repo
2. `lein uberjar` (creates `cider-diet-0.1.0-SNAPSHOT-standalone.jar`).  
   > `java -jar cider-diet-0.1.0-SNAPSHOT-standalone.jar [<port_number>]` starts nREPL on port `<port_number>` (7888 by default).

3. Put that `jar` somewhere
4. Use the following function:
``` elisp
(setq cider-diet-path ...) ;; set path to cider-diet-0.1.0-SNAPSHOT-standalone.jar

(defun cider-diet-jack-in ()
  (interactive)
  ;; start nREPL
  (let ((diet-nrepl (start-process "cider-diet-nrepl" "*cider-diet-nrepl*"  "java" "-jar" cider-diet-path))) 
    (accept-process-output diet-nrepl)
    (cider-connect "localhost" 7888)))
```

Then just call `cider-diet-jack-in` to start nREPL and make `cider` connect ot it.

## Results

For me it takes **4 seconds** to have working `cider` connected to `nREPL`.  
I'm not sure if all `middleware` works, but at least I have pretty-printed stacktraces and other stuff.  

## TODO

1. Clean up
2. Integrate with `cider` properly
3. Check and fix dependencies
4. Check if everything really works

## License

Copyright © 2016 kovrik

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.