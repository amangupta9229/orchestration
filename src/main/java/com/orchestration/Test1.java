package com.orchestration;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.okhttp.OkHttpDockerCmdExecFactory;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("legacy")
public class Test1 {
    DockerClient dockerClient;
    @PostConstruct
    public void fun2() {
    DefaultDockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().build();
    dockerClient = DockerClientImpl.getInstance(config)
            .withDockerCmdExecFactory(new OkHttpDockerCmdExecFactory());
    }

    @GetMapping("hello")
    public String hi(){
        DefaultDockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().build();

        DockerClient dockerClient = DockerClientImpl.getInstance(config)
                .withDockerCmdExecFactory(new OkHttpDockerCmdExecFactory());

        System.out.println("Docker client initialized successfully.");
        System.out.println("Docker version: " + dockerClient.versionCmd().exec().getVersion());

        return "hello";
    }

    @GetMapping("start")
    public String start(){
    CreateContainerResponse container = dockerClient.createContainerCmd("nginx")
            .withName("my-nginx")
            .withCmd("nginx", "-g", "daemon off;")
            .exec();
        System.out.println(" details " +container.getId());
        System.out.println(" details 2 " +container.toString());
        dockerClient.startContainerCmd(container.getId()).exec();
        return "hello";
    }


}
