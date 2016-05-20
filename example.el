(setq cider-diet-path (expand-file-name (concat (getenv "HOME")
                                                "/git/cider-diet/target/cider-diet-0.1.0-SNAPSHOT-standalone.jar")))

(defun cider-diet-jack-in ()
  (interactive)
  (let* ((cider-diet-process (start-process "cider-diet-nrepl" "*cider-diet-nrepl*"  "java" "-jar" cider-diet-path "7888"))) 
    (accept-process-output cider-diet-process)
    (cider-connect "localhost" 7888)))