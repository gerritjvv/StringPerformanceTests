(defproject stringbenchmarks "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [  [criterium "0.4.3" :scope "provided"]
                   [org.clojure/clojure "1.6.0"]]
  
  :plugins [[perforate "0.3.3"]]

  :javac-options ["-target" "1.6" "-source" "1.6" "-Xlint:-options"]
  :global-vars {*warn-on-reflection* true
                *assert* false}

  :java-source-paths ["java"]
  :perforate {:benchmark-paths ["bench/"]})
