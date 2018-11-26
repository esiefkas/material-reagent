(defproject material-reagent "0.1.0-SNAPSHOT"
  :description "Another shot at a reagent wrapper for material-ui"
  :url "https://github.com/raxod502/minimal-webapp"
  :license {:name "MIT License"
            :url "http://www.opensource.org/licenses/mit-license.php"}

  :dependencies [;; Language
                 [org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.439"]

                 ;; Server
                 [compojure "1.6.1"]
                 [hiccup "1.0.5"]
                 [ring/ring-jetty-adapter "1.5.0"]

                 ;; Client
                 [reagent "0.8.1"]

                 ;; Emacs integration
                 [cider/piggieback "0.3.10"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.17"]]

  :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}
 
  :cljsbuild {:builds [{:id "main"
                        :source-paths ["src"]
                        :figwheel true
                        :compiler {:main "material-reagent.pages.splash"
                                   :output-to "resources/public/js/main.js"
                                   :output-dir "resources/public/js/out"
                                   :asset-path "js/out"}}]}
  :figwheel {:ring-handler material-reagent.server/site}

  :clean-targets ^{:protect false} ["resources/public" "target"]

  :uberjar-name "material-reagent-standalone.jar"
  :profiles {:uberjar {:aot :all
                       :main minimal-webapp.server
                       :hooks [leiningen.cljsbuild]}})
