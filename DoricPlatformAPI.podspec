Pod::Spec.new do |s|
    s.name             = 'DoricPlatformAPI'
    s.version          = '0.1.0'
    s.summary          = 'Doric extension library'
  
    #s.description      = <<-DESC
    #                         DESC
    s.homepage         = 'https://github.com/doric-pub/DoricPlatformAPI'
    s.license          = { :type => 'Apache-2.0', :file => 'LICENSE' }
    s.author           = { 'pengfei.zhou' => 'pengfei.zhou@foxmail.com' }
    s.source           = { :git => 'https://github.com/doric-pub/DoricPlatformAPI.git', :tag => s.version.to_s }
    
    s.ios.deployment_target = '9.0'
  
    s.source_files = 'iOS/Classes/**/*'
    s.resource     =  "dist/**/*"
    s.public_header_files = 'iOS/Classes/**/*.h'
    s.dependency 'DoricCore'
end
