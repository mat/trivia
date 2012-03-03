
require File.expand_path(File.dirname(__FILE__) + '/spec_helper')
require 'new_trivia/game'

describe NewTrivia do

 describe "integration" do
   10.times do
     seed = rand(1000)
     it "behaves like the old impl with seed (#{seed})" do
       ENV['TRIVIA_SEED'] = seed.to_s
       old_out =  `ruby bin/trivia`
       new_out =  `ruby bin/new_trivia`
       old_out.should == new_out
     end
   end
 end

end

