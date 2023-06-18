package codecrusaders.business.impl;

import codecrusaders.domain.*;
import codecrusaders.repository.ErrorMessageRepository;
import codecrusaders.repository.TestStepRepository;
import codecrusaders.repository.entity.ErrorEntity;
import codecrusaders.repository.entity.TestStepEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.description;
@ExtendWith(MockitoExtension.class)
public class ErrorMessageManagerTest {

//
//    @Mock
//    ErrorMessageRepository errorMessageRepository;
//    @InjectMocks
//    ErrorMessageManager testStepManager;
//    private final ErrorMessage em = ErrorMessage.builder().id(1L).message("test").build();
//    private final ErrorEntity eme = ErrorEntity.builder().errorid(1L).errorMessage("test").build();
//
//    private final ErrorMessage em2 = ErrorMessage.builder().message("test").build();
//    private final CreateTestStepRequest request = CreateTestStepRequest.builder().subTestId(1L).testResult(true).description("test").message(em2).name("name").build();
//    private  final Long testStepId = 1L;
//    private final CreateTestStepResponse expectedResponse = CreateTestStepResponse.builder().testStepId(testStepId).build();
//    private final TestStepEntity testStepEntityArgument = TestStepEntity.builder().subTestID(1L).testResult(true).testStepName("name").description("test").errorID(0L).build();
//    final TestStepEntity testStepEntityReturn = TestStepEntity.builder().id(testStepId).subTestID(1L).testResult(true).testStepName("name").description("test").errorID(0L).build();
//
//
//    private final List<TestStep> testSteps= List.of(new TestStep(1L,"name",2L, true,"test",1L),new TestStep(2L,"name",2L, true,"test",1L));
//    private final List<TestStepEntity> testStepsEntities = List.of(new TestStepEntity(1L,"name",true, 1L,"test",2L),new TestStepEntity(2L,"name",true, 1L,"test",2L));
//    @Test
//    void shouldCreateTestStepWithAllFields(){
//        //arrange
//        // TestStepRepository repository = mock(TestStepRepository.class);
//        // ErrorMessageRepository repository2 = mock(ErrorMessageRepository.class);
//        when(errorMessageRepository.save(testStepEntityArgument)).thenReturn(testStepEntityReturn);
//
//        // TestStepManager manager = new TestStepManager(repository,repository2);
//
//        //act
//        CreateTestStepResponse actualResponse = testStepManager.registerTestStep(request);
//
//        //assert
//        assertEquals(actualResponse, expectedResponse, "Wrong response is returned");
//        verify(errorMessageRepository, description("Save of repo is not called (with correct argument).")).save(testStepEntityArgument);
//    }
//    @Test
//    void shouldReturnAllTestSteps(){
//        //arrange
//        //TestStepRepository repository = mock(TestStepRepository.class);
//        // ErrorMessageRepository repository2 = mock(ErrorMessageRepository.class);
//        when(errorMessageRepository.findAll()).thenReturn(testStepsEntities);
//
//        //TestStepManager manager = new TestStepManager(repository,repository2);
//
//        //act
//        GetTestStepsResponse actualResponse = testStepManager.getTestSteps();
//
//        //assert
//        assertEquals(testSteps,actualResponse.getTestSteps() , "Wrong list is returned by SUT.");
//        verify(errorMessageRepository, description("Method finalAll of repo is not called.")).findAll();
//    }
}
